package ab.tjl.tc.dubbo.api.controller;

import ab.tjl.tc.dubbo.api.service.HouseResourcesService;
import ab.tjl.tc.dubbo.api.vo.TableResult;
import ab.tjl.tc.dubbo.server.pojo.HouseResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Author:TangJiLin
 * @Description:房源控制层
 * @Date: Created in 2019/11/24 15:18
 * @Modified By:
 */
@Controller
@RequestMapping("house/resources")
public class HouseResourcesController {
    @Autowired
    private HouseResourcesService houseResourcesService;
    /**
     * 新增房源
     *
     * @param houseResources json数据
     * @return
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources){
        try {
            boolean bool = this.houseResourcesService.save(houseResources);
            if(bool){
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查询房源列表
     *
     * @param houseResources
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<TableResult> list(HouseResources houseResources,
                                            @RequestParam(name = "currentPage",
                                                    defaultValue = "1") Integer currentPage,
                                            @RequestParam(name = "pageSize",
                                                    defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(this.houseResourcesService.queryList(houseResources, currentPage, pageSize));
    }

}
