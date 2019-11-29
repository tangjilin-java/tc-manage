package ab.tjl.tc.dubbo.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:TangJiLin
 * @Description:graphql传输
 * @Date: Created in 2019/11/27 13:20
 * @Modified By:
 */
@RequestMapping("graphql")
@Controller
@CrossOrigin
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    private static final ObjectMapper MAPPER = new ObjectMapper();


    /**
     * 实现GraphQL查询
     *
     * @param query
     * @return
     */
    @GetMapping
    @ResponseBody
    public Map<String, Object> query(@RequestParam("query") String query,
                                     @RequestParam(value = "variables", required = false)String variablesJson,
                                     @RequestParam(value = "operationName",required = false)String operationName) {
        try{
            Map variables = MAPPER.readValue(variablesJson, MAPPER.getTypeFactory()
                    .constructMapType(HashMap.class, String.class, Object.class));
            return this.executeQuery(query, operationName, variables);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> error = new HashMap<>();
        error.put("status", 500);
        error.put("msg", "查询出错");
        return error;
    }

    /**
     * 1. GraphQL服务没有支持cross
     * 2. Apollo Client发起的数据请求为POST请求，现在实现的GraphQL仅仅实现了GET请求处理
     * 所以下面这个方法解决了post请求
     * @param map
     * @return
     */
    @PostMapping
    @ResponseBody
    public Map<String, Object> postQuery(@RequestBody Map<String, Object > map) {

        try {
            String query = (String) map.get("query");
            if(null == query){
                query = "";
            }
            String operationName = (String) map.get("operationName");
            Map variables = (Map) map.get("variables");
            if(variables == null){
                variables = Collections.EMPTY_MAP;
            }

            return this.executeQuery(query, operationName, variables);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> error = new HashMap<>();
        error.put("status", 500);
        error.put("msg", "查询出错");
        return error;
    }

    private Map<String, Object> executeQuery(String query, String
            operationName, Map<String, Object> variables) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .operationName(operationName)
                .variables(variables)
                .build();
        return this.graphQL.execute(executionInput).toSpecification();
    }



}
