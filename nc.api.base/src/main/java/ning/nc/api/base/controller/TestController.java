package ning.nc.api.base.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import ning.nc.framework.mvc.JsonResponse;
import ning.nc.service.manager.TestManager;
import ning.nc.service.model.dos.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Date: 2024/1/12
 * @Author： wnn
 * @Description: 免权限测试
 */
@RestController
@RequestMapping("/test")
@Api(description = "测试相关API", tags = "测试相关API")
public class TestController {

    @Autowired
    private TestManager testManager;
    @ApiOperation(value = "获取测试信息")
    @GetMapping("/get_by_id/{id}")
    public JsonResponse getById(@PathVariable("id") Integer id) {
        return JsonResponse.successResponse(testManager.getModel(id));
    }

    @ApiOperation(value = "提交信息")
    @PostMapping("/save_test")
    public JsonResponse saveTest(@Valid TestDO testDO) {
        testManager.add(testDO);
        return JsonResponse.successResponse(testDO);
    }
}
