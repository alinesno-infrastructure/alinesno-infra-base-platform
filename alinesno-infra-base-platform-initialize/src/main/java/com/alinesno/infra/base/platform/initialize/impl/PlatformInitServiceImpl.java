package com.alinesno.infra.base.platform.initialize.impl;

import com.alinesno.infra.base.platform.entity.*;
import com.alinesno.infra.base.platform.enums.OwnerEnums;
import com.alinesno.infra.base.platform.initialize.ContentGenerationStrategy;
import com.alinesno.infra.base.platform.initialize.IPlatformInitService;
import com.alinesno.infra.base.platform.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 平台初始化服务实现类
 */
@Slf4j
@Service
public class PlatformInitServiceImpl implements IPlatformInitService {

    @Autowired
    private IProductTypeService productTypeService ;

    @Autowired
    private IProductItemService productItemService ;

    @Autowired
    private ISolutionTypeService solutionTypeService ;

    @Autowired
    private ISolutionManageService solutionManageService ;

    @Autowired
    private IContentService contentService ;

    @Override
    public void initProductType() {

        // 实例化产品类型
        ProductTypeEntity basicService = createProductTypeEntity("基础服务",
                "alinesno-infra-base",
                "http://data.linesno.com/banner/1.png",
                2,
                null,
                "fa-brands fa-python",
                "提供基本的服务支持，包括但不限于基础设施建设和维护等服务。");

        ProductTypeEntity inferenceService = createProductTypeEntity("推理服务",
                "alinesno-infra-brain",
                "http://data.linesno.com/banner/2.png",
                1,
                null,
                "fa-solid fa-truck-monster",
                "提供机器学习模型推理计算能力，帮助用户快速实现模型部署和应用。");

        ProductTypeEntity dataInference = createProductTypeEntity("数据推理",
                "alinesno-infra-data",
                "http://data.linesno.com/banner/3.png",
                3,
                null,
                "fa-solid fa-screwdriver-wrench",
                "基于大数据的推理分析服务，通过智能算法处理海量数据，提取有价值的信息。");

        ProductTypeEntity operationMaintenance = createProductTypeEntity("运维服务",
                "alinesno-infra-operation",
                "http://data.linesno.com/banner/4.png",
                4,
                null,
                "fa-solid fa-shuttle-space",
                "提供全面的运维支持和服务，包括监控、故障排查、性能优化等。");

        ProductTypeEntity operationService = createProductTypeEntity("运营服务",
                "alinesno-infra-platform",
                "http://data.linesno.com/banner/5.png",
                5,
                null,
                "fa-solid fa-truck-field-un",
                "提供专业的运营策略和服务，帮助企业提高业务效率和市场竞争力。");

        List<ProductTypeEntity> productTypeEntityList = new ArrayList<>();
        productTypeEntityList.add(basicService);
        productTypeEntityList.add(inferenceService);
        productTypeEntityList.add(dataInference);
        productTypeEntityList.add(operationMaintenance);
        productTypeEntityList.add(operationService);

        AtomicLong id = new AtomicLong(1L);
        productTypeEntityList.forEach(item -> {
           item.setId(id.getAndIncrement());
           item.setTypeOwner(OwnerEnums.PLATFORM.getCode());
        });

        productTypeService.saveOrUpdateBatch(productTypeEntityList) ;
    }

    public static ProductTypeEntity createProductTypeEntity(String name , String code, String banner,  int sortNumber, Long parentId, String icon, String typeDescribe) {
        ProductTypeEntity entity = new ProductTypeEntity();
        entity.setName(name);
        entity.setBanner(banner);
        entity.setCode(code);
        entity.setSortNumber(sortNumber);
        entity.setParentId(parentId == null ? 0L : parentId);
        entity.setIcon(icon);
        entity.setTypeDescribe(typeDescribe); // 添加这一行
        return entity;
    }

    public static ProductItemEntity createProductItemEntity(String name, String productBrief, String productDescribe, String linkPath, String prodStatus, int hasInner , String icon) {

        ProductItemEntity entity = new ProductItemEntity();
        entity.setName(name);
        entity.setProductBrief(productBrief);
        entity.setProductDescribe(productDescribe);
        entity.setSubName("运营服务");
        entity.setBanner("fas fa-chalkboard-teacher");
        entity.setLinkPath(linkPath);
        entity.setProdStatus(prodStatus);
        entity.setHasInner(hasInner);
        entity.setIcon(icon);

        return entity;
    }

    @Override
    public void initProduct() {

        List<ProductItemEntity> allService = getProductItemEntities();

        productItemService.saveOrUpdateBatch(allService) ;
    }

    private List<ProductItemEntity> getProductItemEntities() {
        // 技术服务
        ProductItemEntity authorityConfigurationService = createProductItemEntity("权限配置服务", "alinesno-infra-base-authority", "权限配置服务", "http://alinesno-infra-base-authority-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-key");
        ProductItemEntity codeGeneratorService = createProductItemEntity("代码生成器", "alinesno-infra-base-init", "代码生成器", "http://alinesno-infra-base-starter-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-code");
        ProductItemEntity distributedConfigurationService = createProductItemEntity("分布式配置服务", "alinesno-infra-base-config", "分布式配置服务", "http://alinesno-infra-base-config-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-cogs");
        ProductItemEntity transactionalMessageService = createProductItemEntity("事务消息服务", "alinesno-infra-base-message", "事务消息服务", "http://alinesno-infra-base-message-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-envelope");
        ProductItemEntity storageManagementService = createProductItemEntity("存储管理服务", "alinesno-infra-base-storage", "存储管理服务", "http://alinesno-infra-base-storage-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-database");
        ProductItemEntity gatewayConfigurationService = createProductItemEntity("网关配置服务", "alinesno-infra-base-gateway", "网关配置服务", "http://alinesno-infra-base-gateway-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-network-wired");
        ProductItemEntity vectorSearchService = createProductItemEntity("向量库搜索服务", "alinesno-infra-base-document", "向量库搜索服务", "http://alinesno-infra-base-search-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-search");
        ProductItemEntity sensitiveWordFilterService = createProductItemEntity("敏感词过滤服务", "alinesno-infra-base-sensitive", "敏感词过滤服务", "http://alinesno-infra-base-sensitive-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-shield-alt");
        ProductItemEntity aggregatedPaymentService = createProductItemEntity("聚合支付服务", "alinesno-infra-base-pay", "聚合支付服务", "http://alinesno-infra-base-pay-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-credit-card");
        ProductItemEntity contentManagementSystemService = createProductItemEntity("内容管理系统服务", "alinesno-infra-base-cms", "内容管理系统服务", "http://alinesno-infra-base-cms-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-file-alt");

        List<ProductItemEntity> technicalService = new ArrayList<>() ;
        technicalService.add(authorityConfigurationService);
        technicalService.add(codeGeneratorService);
        technicalService.add(distributedConfigurationService);
        technicalService.add(transactionalMessageService);
        technicalService.add(storageManagementService);
        technicalService.add(gatewayConfigurationService);
        technicalService.add(vectorSearchService);
        technicalService.add(sensitiveWordFilterService);
        technicalService.add(aggregatedPaymentService);
        technicalService.add(contentManagementSystemService);

        technicalService.forEach(item -> {
            item.setProductTypeId(productTypeService.getOne(new LambdaQueryWrapper<ProductTypeEntity>().eq(ProductTypeEntity::getName, "基础服务")).getId().toString());
        }) ;


        // 数据服务
        ProductItemEntity heterogeneousSystemExtractionService = createProductItemEntity("异构系统抽取服务", "alinesno-infra-data-pipeline", "提供数据集成的功能，用于将不同数据源的数据进行整合和转换", "http://alinesno-infra-data-pipeline-ui.beta.data.infra.linesno.com", "normal", 0, "fas fa-exchange-alt");
        ProductItemEntity kettleDebugManagementService = createProductItemEntity("Kettle调试管理服务", "alinesno-infra-data-integration", "基于Kettle的数据集成服务，集成DataOps能力，用于将不同数据源的数据进行整合和转换", "http://alinesno-infra-data-integration-ui.beta.data.infra.linesno.com", "normal", 0, "fas fa-tools");
        ProductItemEntity masterDataService = createProductItemEntity("主数据服务", "alinesno-infra-data-mdm", "主数据服务", "http://alinesno-infra-data-mdm-ui.beta.data.infra.linesno.com", "normal", 0, "fas fa-database");
        ProductItemEntity dataOrchestrationService = createProductItemEntity("数据编排计算服务", "alinesno-infra-data-dolphinscheduler", "数据编排计算服务", "http://alinesno-infra-data-dolphinscheduler-ui.beta.data.infra.linesno.com", "normal", 0, "fas fa-project-diagram");
        ProductItemEntity realTimeComputingService = createProductItemEntity("实时计算服务", "alinesno-infra-data-flink", "实时计算服务", "http://alinesno-infra-data-stream-ui.beta.data.infra.linesno.com", "normal", 0, "fas fa-stream");
        ProductItemEntity dataAssetService = createProductItemEntity("数据资产服务", "alinesno-infra-data-assets", "数据资产服务", "http://alinesno-infra-data-assets-ui.beta.data.infra.linesno.com", "normal", 0, "fas fa-coins");

        List<ProductItemEntity> dataService = new ArrayList<>() ;
        dataService.add(heterogeneousSystemExtractionService);
        dataService.add(kettleDebugManagementService);
        dataService.add(masterDataService);
        dataService.add(dataOrchestrationService);
        dataService.add(realTimeComputingService);
        dataService.add(dataAssetService);

        dataService.forEach(item -> {
            item.setProductTypeId(productTypeService.getOne(new LambdaQueryWrapper<ProductTypeEntity>().eq(ProductTypeEntity::getName, "数据推理")).getId().toString());
        }) ;

        // 推理服务
        ProductItemEntity ocrService = createProductItemEntity("OCR视觉识别服务", "alinesno-infra-smart-ocr", "OCR视觉识别服务", "http://alinesno-infra-smart-ocr-ui.beta.smart.infra.linesno.com", "normal", 0, "fas fa-text-height");
        ProductItemEntity nlpService = createProductItemEntity("自然语言识别服务", "alinesno-infra-smart-nlp", "自然语言识别服务", "http://alinesno-infra-smart-nlp-ui.beta.smart.infra.linesno.com", "normal", 0, "fas fa-language");
        ProductItemEntity largeModelInferenceService = createProductItemEntity("大模型推理服务", "alinesno-infra-smart-brain", "大模型推理服务", "http://alinesno-infra-smart-brain-ui.beta.smart.infra.linesno.com", "normal", 0, "fas fa-brain");
        ProductItemEntity objectDetectionService = createProductItemEntity("目标检测识别服务", "alinesno-infra-smart-detection", "目标检测识别服务", "http://alinesno-infra-smart-detection-ui.beta.smart.infra.linesno.com", "normal", 0, "fas fa-crosshairs");

        List<ProductItemEntity> smartService = new ArrayList<>() ;
        smartService.add(ocrService);
        smartService.add(nlpService);
        smartService.add(largeModelInferenceService);
        smartService.add(objectDetectionService);

        smartService.forEach(item -> {
            item.setProductTypeId(productTypeService.getOne(new LambdaQueryWrapper<ProductTypeEntity>().eq(ProductTypeEntity::getName, "推理服务")).getId().toString());
        }) ;

        // 运维服务
        ProductItemEntity automationOpsService = createProductItemEntity("自动化运维服务", "alinesno-infra-ops-scheduler", "自动化运维服务", "http://alinesno-infra-ops-scheduler-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-cogs");
        ProductItemEntity distributedLogService = createProductItemEntity("分布式日志服务", "alinesno-infra-ops-logback", "分布式日志服务", "http://alinesno-infra-ops-logback-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-file-alt");
        ProductItemEntity containerManagementService = createProductItemEntity("容器管理服务", "alinesno-infra-ops-container", "容器管理服务", "http://alinesno-infra-ops-container-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-cube");
        ProductItemEntity monitoringAlertService = createProductItemEntity("监控预警服务", "alinesno-infra-ops-watcher", "监控预警服务", "http://alinesno-infra-ops-watcher-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-eye");

        List<ProductItemEntity> opsService = new ArrayList<>() ;
        opsService.add(automationOpsService);
        opsService.add(distributedLogService);
        opsService.add(containerManagementService);
        opsService.add(monitoringAlertService);

        opsService.forEach(item -> {
            item.setProductTypeId(productTypeService.getOne(new LambdaQueryWrapper<ProductTypeEntity>().eq(ProductTypeEntity::getName, "运维服务")).getId().toString());
        }) ;

        // 运营服务
        ProductItemEntity infrastructurePlatformService = createProductItemEntity("基设平台管理服务", "alinesno-infra-base-platform", "基设平台管理服务", "http://alinesno-infra-base-platform-ui.beta.base.infra.linesno.com", "normal", 0, "fas fa-server");
        ProductItemEntity securityTouchService = createProductItemEntity("安全感触服务", "alinesno-infra-plat-security", "安全感触服务", "http://alinesno-infra-plat-security-ui.beta.plat.infra.linesno.com", "normal", 0, "fas fa-shield-alt");
        ProductItemEntity realTimeRecommendationService = createProductItemEntity("实时推荐服务", "alinesno-infra-bus-recommend", "实时推荐服务", "http://alinesno-infra-bus-recommend-ui.beta.data.infra.linesno.com", "normal", 0, "fas fa-chart-line");
        ProductItemEntity realTimeProfilingService = createProductItemEntity("实时画像服务", "alinesno-infra-bus-profiling", "实时画像服务", "http://alinesno-infra-bus-profiling-ui.beta.data.infra.linesno.com", "normal", 0, "fas fa-user-circle");

        List<ProductItemEntity> busService = new ArrayList<>() ;
        busService.add(infrastructurePlatformService);
        busService.add(securityTouchService);
        busService.add(realTimeRecommendationService);
        busService.add(realTimeProfilingService);

        busService.forEach(item -> {
            item.setProductTypeId(productTypeService.getOne(new LambdaQueryWrapper<ProductTypeEntity>().eq(ProductTypeEntity::getName, "运营服务")).getId().toString());
        }) ;


        List<ProductItemEntity> allService = new ArrayList<>() ;

        allService.addAll(technicalService) ;
        allService.addAll(dataService) ;
        allService.addAll(smartService) ;
        allService.addAll(opsService) ;
        allService.addAll(busService) ;

        AtomicLong id = new AtomicLong(1L);
        allService.forEach(item -> {
            item.setId(id.getAndIncrement());
            item.setProductOwner(OwnerEnums.PLATFORM.getCode());
        });
        return allService;
    }

    @Override
    public void initPlanType() {

        // 实例化解决方案类型
        SolutionTypeEntity modernization = createSolutionTypeEntity("进行现代化改造", "通过对贵组织的业务应用组合进行评估、规划、实施和衡量，实现现代化改造和简化，提升系统的整体效率和灵活性。", null, "fas fa-laptop-code");
        SolutionTypeEntity businessPlatform = createSolutionTypeEntity("业务中台", "构建和优化业务中台系统，实现业务功能的集成和共享，提升组织的业务处理能力和灵活性。", null, "fas fa-network-wired");
        SolutionTypeEntity dataGovernance = createSolutionTypeEntity("数据治理", "建立完善的数据治理体系，通过数据标准化、数据质量管理和数据资产管理，提升数据的准确性和可用性。", null, "fas fa-database");
        SolutionTypeEntity operationSolution = createSolutionTypeEntity("运维方案", "提供系统的运维和管理解决方案，包括自动化运维、监控、日志管理和性能优化，确保系统的稳定性和可靠性。", null, "fas fa-server");

        List<SolutionTypeEntity> allType = new ArrayList<>() ;
        allType.add(modernization);
        allType.add(businessPlatform);
        allType.add(dataGovernance);
        allType.add(operationSolution);

        AtomicLong id = new AtomicLong(1L);
        allType.forEach(item -> {
            item.setId(id.getAndIncrement());
        });

        solutionTypeService.saveOrUpdateBatch(allType) ;
    }

    public static SolutionTypeEntity createSolutionTypeEntity(String typeName,
                                                              String typeDescribe,
                                                              Long parentId ,
                                                              String icon) {
        SolutionTypeEntity entity = new SolutionTypeEntity();
        entity.setTypeName(typeName);
        entity.setTypeDescribe(typeDescribe);
        entity.setParentId(parentId);
        entity.setIcon(icon);
        return entity;
    }


    @Override
    public void initPlan() {

        // 创建解决方案实体列表
        List<SolutionManageEntity> solutionList = ContentGenerationStrategy.getSolutionManageEntities();

        solutionManageService.saveOrUpdateBatch(solutionList) ;
    }


    @Override
    public void initNotice() {

    }

    @Override
    public void initContent() {
        List<ContentEntity> contentList = ContentGenerationStrategy.getContents() ;
        contentService.saveOrUpdateBatch(contentList) ;
    }

    @Override
    public void initFriendLink() {

    }
}
