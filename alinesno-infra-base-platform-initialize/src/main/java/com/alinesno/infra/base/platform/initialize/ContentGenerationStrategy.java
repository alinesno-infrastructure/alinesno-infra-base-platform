package com.alinesno.infra.base.platform.initialize;

import com.alinesno.infra.base.platform.entity.ContentEntity;
import com.alinesno.infra.base.platform.entity.SolutionManageEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ContentGenerationStrategy {

    public static List<ContentEntity> getContents() {
        List<ContentEntity> contents = new ArrayList<>();

        // 新最公告
        generateTitles(contents, "NewImportantAnnouncements",
            "关于公司最新政策的通知",
            "2024年度财务报告发布",
            "重要会议变更通知",
            "新产品发布会日期公布",
            "员工福利调整说明",
            "安全生产条例更新",
            "客户满意度调查结果",
            "公司搬迁至新办公地点",
            "团队建设活动安排",
            "年度优秀员工表彰大会"
        );

        // 探索AIP使用
        generateTitles(contents, "ExploringAIPUsage",
            "如何利用AI提高生产效率",
            "AI在客户服务中的应用案例",
            "机器学习在推荐系统的实践",
            "自然语言处理技术的最新进展",
            "计算机视觉技术在制造业的应用",
            "语音识别在智能家居中的作用",
            "自动驾驶技术的安全挑战",
            "区块链技术在供应链管理中的潜力",
            "智能合约的法律合规性探讨",
            "物联网(IoT)设备的安全防护策略"
        );

        // 数据解决方案
        generateTitles(contents, "DataSolutions",
            "大数据分析在医疗行业的应用",
            "企业级数据仓库构建指南",
            "数据湖(Data Lake)的最佳实践",
            "数据安全和隐私保护策略",
            "使用NoSQL数据库优化数据分析",
            "数据挖掘技术在金融风控中的应用",
            "数据治理框架的设计与实施",
            "数据科学项目管理流程",
            "数据可视化工具的选型建议",
            "云数据服务的成本效益分析"
        );

        // AIP 服务运营方式
        generateTitles(contents, "AIPServiceOperations",
            "AIP服务的日常运维流程",
            "提高AIP服务质量的关键策略",
            "AIP平台的监控与告警机制",
            "AIP系统的性能优化方法",
            "AIP服务的可扩展性设计原则",
            "AIP数据模型的训练与更新",
            "AIP算法版本控制的重要性",
            "AIP服务的安全认证机制",
            "AIP故障排查与恢复策略",
            "AIP服务的持续集成(CI)和持续部署(CD)"
        );

        // 流媒体识别使用方式
        generateTitles(contents, "StreamingMediaRecognitionUsage",
            "流媒体实时识别技术的应用",
            "基于深度学习的视频识别案例",
            "流媒体直播中的版权保护措施",
            "流媒体平台的内容审核机制",
            "流媒体传输协议的选择与实现",
            "流媒体广告投放策略优化",
            "流媒体播放器的用户体验改进",
            "流媒体加密技术的最新趋势",
            "流媒体内容推荐算法的设计",
            "流媒体播放质量的评估标准"
        );

        // 微服务技术使用解决方案
        generateTitles(contents, "MicroservicesTechnologySolutions",
            "微服务架构设计与最佳实践",
            "微服务治理平台的构建方案",
            "微服务之间的通信协议选择",
            "微服务集群的负载均衡策略",
            "微服务的容器化部署技术",
            "微服务环境下的故障隔离机制",
            "微服务API网关的功能与配置",
            "微服务的状态管理与持久化",
            "微服务的灰度发布与回滚",
            "微服务监控与日志收集方案"
        );

        // Print the list to verify the data

        return contents ;
    }

    private static void generateTitles(List<ContentEntity> contents, String category, String... titles) {
        for (String title : titles) {
            contents.add(new ContentEntity(category, title,  "简介...", "/path/to/default_image.jpg",contents.size()+1));
        }
    }

    public static List<SolutionManageEntity> getSolutionManageEntities() {
        List<SolutionManageEntity> solutionList = new ArrayList<>();
        solutionList.add(new SolutionManageEntity()
                .setTitle("自动化运维解决方案")
                .setContent("该解决方案旨在帮助企业实现运维流程的自动化，减少人工干预，提高运维效率和可靠性。")
                .setLink("https://example.com/auto-ops-solution")
                .setSolutionTypeId(1L)
                .setRemark("适用于大型企业的IT运维部门。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("分布式日志分析解决方案")
                .setContent("该解决分布式系统的日志进行集中管理和分析，实现故障排查和性能优化。")
                .setLink("https://example.com/log-analysis-solution")
                .setSolutionTypeId(2L)
                .setRemark("支持多种日志格式和数据源。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("AI智能运维解决方案")
                .setContent("该解决方案旨在应用人工智能技术，实现智能化的运维管理，提升系统的稳定性和可靠性。")
                .setLink("https://example.com/ai-ops-solution")
                .setSolutionTypeId(3L)
                .setRemark("利用机器学习算法预测潜在问题。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("数据中台建设解决方案")
                .setContent("该解决方案建设数据中台，实现数据的集中管理和共享应用。")
                .setLink("https://example.com/data-mid-platform-solution")
                .setSolutionTypeId(4L)
                .setRemark("支持实时数据分析和数据湖构建。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("数据报表分析解决方案")
                .setContent("该解决方案实现数据报表的自动化生成和分析，提供决策支持和业务洞察。")
                .setLink("https://example.com/data-reporting-solution")
                .setSolutionTypeId(5L)
                .setRemark("支持自定义报表模板和多维度分析。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("用户画像解决方案")
                .setContent("该解决方案构建用户画像，深入了解用户需求和行为，进行个性化推荐。")
                .setLink("https://example.com/user-profile-solution")
                .setSolutionTypeId(6L)
                .setRemark("支持多种用户行为跟踪和分析。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("运维应用画像解决方案")
                .setContent("该解决方案实现运维应用的画像管理，提高运维效率。")
                .setLink("https://example.com/ops-application-profile-solution")
                .setSolutionTypeId(7L)
                .setRemark("用于监控和优化运维工具性能。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("传统企业转变成业务中台解决方案")
                .setContent("该解决方案旨在帮助传统企业实现业务中台转型。")
                .setLink("https://example.com/traditional-to-business-mid-platform-solution")
                .setSolutionTypeId(8L)
                .setRemark("支持传统业务流程的数字化转型。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("企业业务中台建设解决方案")
                .setContent("该解决方案旨在帮助企业建设业务中台，实现业务的集中管理和协同发展。")
                .setLink("https://example.com/business-mid-platform-construction-solution")
                .setSolutionTypeId(9L)
                .setRemark("提供统一的数据和服务接口。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("新旧结合业务微服务解决方案")
                .setContent("该解决方案结合了传统业务和微服务架构，帮助企业实现业务的快速创新和灵活扩展。")
                .setLink("https://example.com/legacy-and-microservices-solution")
                .setSolutionTypeId(10L)
                .setRemark("支持混合云部署和DevOps流程。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("企业超级自动化解决方案")
                .setContent("该解决方案旨在帮助企业实现超级自动化转型，提升业务流程的效率和用户体验。")
                .setLink("https://example.com/super-automation-solution")
                .setSolutionTypeId(11L)
                .setRemark("涵盖RPA、AI和流程优化。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("传统业务进行容器云迁移")
                .setContent("迁移到容器云平台，以提高应用的弹性、可扩展性和部署效率。")
                .setLink("https://example.com/container-cloud-migration-solution")
                .setSolutionTypeId(12L)
                .setRemark("支持Kubernetes和Docker。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("软件供应链最佳实践")
                .setContent("实施 DevOps 的各种流程和资源，以加速软件交付和提高运维效率。")
                .setLink("https://example.com/software-supply-chain-best-practices")
                .setSolutionTypeId(13L)
                .setRemark("包括CI/CD流水线和安全审计。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("实施 DevOps 流程和资源")
                .setContent("帮助在组织中实施 DevOps 的各种流程和资源,可扩展性和部署效率。")
                .setLink("https://example.com/devops-implementation-solution")
                .setSolutionTypeId(14L)
                .setRemark("支持敏捷开发和持续集成。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("使用一致的平台管理工作负载")
                .setContent("跨多个云环境管理和部署工作负载，以实现多云环境下的应用现代化和灵活性。")
                .setLink("https://example.com/consistent-platform-workload-management-solution")
                .setSolutionTypeId(15L)
                .setRemark("支持公有云、私有云和混合云。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("全代管式环境")
                .setContent("提供全代管式的开发、部署和扩缩容环境，无需关注底层智能体平台。")
                .setLink("https://example.com/fully-managed-environment-solution")
                .setSolutionTypeId(16L)
                .setRemark("适用于无服务器架构。"));

        solutionList.add(new SolutionManageEntity()
                .setTitle("API 优先方法")
                .setContent("对旧式应用进行现代化改造，加快新开发模式的实施和应用集成。")
                .setLink("https://example.com/api-first-approach-solution")
                .setSolutionTypeId(17L)
                .setRemark("支持RESTful API设计和文档。"));

        AtomicLong id = new AtomicLong(1L);
        solutionList.forEach(item -> {
            item.setId(id.getAndIncrement());
        });
        return solutionList;
    }
}