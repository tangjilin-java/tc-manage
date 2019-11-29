package ab.tjl.tc.dubbo.api.controller;

import ab.tjl.tc.dubbo.api.config.MockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:TangJiLin
 * @Description:前端数据控制层
 * @Date: Created in 2019/11/29 10:15
 * @Modified By:
 */
@RequestMapping("mock")
@RestController
@CrossOrigin
public class MockController {

    @Autowired
    private MockConfig mockConfig;

    /**
     * 菜单
     *
     * @return
     */
    @GetMapping("index/menu")
    public String indexMenu() {
        return this.mockConfig.getIndexMenu();
    }
    /**
     * 首页资讯
     * @return
     */
    @GetMapping("index/info")
    public String indexInfo() {
        return this.mockConfig.getIndexInfo();
    }
    /**
     * 首页问答
     * @return
     */
    @GetMapping("index/faq")
    public String indexFaq() {
        return this.mockConfig.getIndexFaq();
    }
    /**
     * 首页房源信息
     * @return
     */
    @GetMapping("index/house")
    public String indexHouse() {
        return this.mockConfig.getIndexHouse();
    }

    /**
     * 查询资讯
     *
     * @param type
     * @return
     */
    @GetMapping("infos/list")
    public String infosList(@RequestParam("type")Integer type) {
        switch (type){
            case 1:
                return this.mockConfig.getInfosList1();
            case 2:
                return this.mockConfig.getInfosList2();
            case 3:
                return this.mockConfig.getInfosList3();
        }
        return this.mockConfig.getInfosList1();
    }
    /**
     * 我的中心
     * @return
     */
    @GetMapping("my/info")
    public String myInfo() {
        return this.mockConfig.getMy();
    }

}
