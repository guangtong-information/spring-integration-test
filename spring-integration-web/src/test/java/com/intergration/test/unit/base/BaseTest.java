package com.intergration.test.unit.base;


import com.intergration.test.Application;
import com.intergration.test.model.request.base.CommonRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * 单元测试基类
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(locations = {"classpath:test-profile.xml"})
@WebAppConfiguration
@ActiveProfiles("mock")
public abstract class BaseTest {

    @Resource
    protected TestHelper testHelper;

    protected static String PROFILE;
    /**
     * 执行之前
     */
    @Before
    public void setUp() {

        PROFILE = testHelper.getCurrentProfile();

        //通用请求参数赋值
        initRequest();

        //之后mock
        if (isMock()) {
            MockitoAnnotations.initMocks(this);
            fullMock();
        }
    }

    /**
     * 业务相关的Mock
     */
    public abstract void fullMockInner();

    protected boolean isMock() {
        if (Profile.MOCK.getValue().equals(PROFILE)) {
            return true;
        }
        return false;
    }

    public abstract void initRequestInner();
    /**
     * 基本请求
     */
    public void initRequest() {
        initRequestInner();
    }

    private void fullMock() {
        fullMockInner();
    }

}
