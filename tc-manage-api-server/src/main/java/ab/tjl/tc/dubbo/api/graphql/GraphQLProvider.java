package ab.tjl.tc.dubbo.api.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:将GraphQL对象载入到Spring容器中 并且完成GraphQL对象的初始化功能
 * @Date: Created in 2019/11/27 13:25
 * @Modified By:
 */
@Component
public class GraphQLProvider {
    private GraphQL graphQL;


    @Autowired
    private List<MyDataFetcher> myDataFetchers; //注入容器中所有的MyDataFetcher实现类

    @PostConstruct//实现对GraphQL对象的初始化
    public void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:tc.graphqls");
        this.graphQL = GraphQL.newGraphQL(buildGraphQLSchema(file)).build();
    }

    private GraphQLSchema buildGraphQLSchema(File file){
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(file);
            return new SchemaGenerator().makeExecutableSchema(typeRegistry,buildWiring());
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("TCQuery", builder ->{
                            for (MyDataFetcher myDataFetcher : myDataFetchers) {
                                builder.dataFetcher(myDataFetcher.fieldName(),
                                        environment ->  myDataFetcher.dataFetcher(environment));
                            }
                    return builder;
                        }
                       /* builder.dataFetcher("HouseResources",
                                environment -> {
                                    Long id = environment.getArgument("id");
                                    return this.houseResourcesService.queryHouseResourceById(id);
                                })*/


                ).build();
    }


    @Bean
    public GraphQL graphQL(){
        return this.graphQL;
    }
}
