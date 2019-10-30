## Spring Cloud Kotlin Contracts fail in 2.2.0.RC1

Once generating contract test, exception is `java.lang.NoClassDefFoundError: org/jetbrains/kotlin/cli/jvm/repl/GenericReplCompiler`  

## Configuration

Gradle version 
```
Gradle 5.6.3

Build time:   2019-10-18 00:28:36 UTC
Revision:     bd168bbf5d152c479186a897f2cea494b7875d13

Kotlin:       1.3.41
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.14 compiled on March 12 2019
JVM:          11.0.5 (AdoptOpenJDK 11.0.5+10)
OS:           Mac OS X 10.15 x86_64
```

* Spring Boot : 2.2.0.RELEASE
* Spring Cloud : Hoxton.RC1
* Spring Cloud Contract : 2.2.0.RC1

## Run

```bash
./gradlew generateContractTests
```

## Stacktrace

```text
org.gradle.api.tasks.TaskExecutionException: Execution failed for task ':generateContractTests'.
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter$3.accept(ExecuteActionsTaskExecuter.java:166)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter$3.accept(ExecuteActionsTaskExecuter.java:163)
	at org.gradle.internal.Try$Failure.ifSuccessfulOrElse(Try.java:191)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:156)
	at org.gradle.api.internal.tasks.execution.ValidatingTaskExecuter.execute(ValidatingTaskExecuter.java:62)
	at org.gradle.api.internal.tasks.execution.SkipEmptySourceFilesTaskExecuter.execute(SkipEmptySourceFilesTaskExecuter.java:108)
	at org.gradle.api.internal.tasks.execution.ResolveBeforeExecutionOutputsTaskExecuter.execute(ResolveBeforeExecutionOutputsTaskExecuter.java:67)
	at org.gradle.api.internal.tasks.execution.StartSnapshotTaskInputsBuildOperationTaskExecuter.execute(StartSnapshotTaskInputsBuildOperationTaskExecuter.java:62)
	at org.gradle.api.internal.tasks.execution.ResolveAfterPreviousExecutionStateTaskExecuter.execute(ResolveAfterPreviousExecutionStateTaskExecuter.java:46)
	at org.gradle.api.internal.tasks.execution.CleanupStaleOutputsExecuter.execute(CleanupStaleOutputsExecuter.java:94)
	at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
	at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:95)
	at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
	at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:56)
	at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
	at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
	at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
	at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor$CallableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:416)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor$CallableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:406)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor$1.execute(DefaultBuildOperationExecutor.java:165)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.execute(DefaultBuildOperationExecutor.java:250)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.execute(DefaultBuildOperationExecutor.java:158)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:102)
	at org.gradle.internal.operations.DelegatingBuildOperationExecutor.call(DelegatingBuildOperationExecutor.java:36)
	at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
	at org.gradle.execution.plan.LocalTaskNodeExecutor.execute(LocalTaskNodeExecutor.java:43)
	at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:355)
	at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:343)
	at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:336)
	at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:322)
	at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker$1.execute(DefaultPlanExecutor.java:134)
	at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker$1.execute(DefaultPlanExecutor.java:129)
	at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:202)
	at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.executeNextNode(DefaultPlanExecutor.java:193)
	at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:129)
	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
	at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
	at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:56)
Caused by: java.lang.NoClassDefFoundError: org/jetbrains/kotlin/cli/jvm/repl/GenericReplCompiler
	at org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine$replCompiler$2.invoke(KotlinJsr223JvmLocalScriptEngine.kt:47)
	at org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine$replCompiler$2.invoke(KotlinJsr223JvmLocalScriptEngine.kt:38)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine.getReplCompiler(KotlinJsr223JvmLocalScriptEngine.kt)
	at org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine$localEvaluator$2.invoke(KotlinJsr223JvmLocalScriptEngine.kt:53)
	at org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine$localEvaluator$2.invoke(KotlinJsr223JvmLocalScriptEngine.kt:38)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine.getLocalEvaluator(KotlinJsr223JvmLocalScriptEngine.kt)
	at org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine.getReplEvaluator(KotlinJsr223JvmLocalScriptEngine.kt:55)
	at org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine.createState(KotlinJsr223JvmLocalScriptEngine.kt:59)
	at org.jetbrains.kotlin.cli.common.repl.KotlinJsr223JvmScriptEngineBase.createState$default(KotlinJsr223JvmScriptEngineBase.kt:46)
	at org.jetbrains.kotlin.cli.common.repl.KotlinJsr223JvmScriptEngineBase.getCurrentState(KotlinJsr223JvmScriptEngineBase.kt:53)
	at org.jetbrains.kotlin.cli.common.repl.KotlinJsr223JvmScriptEngineBase.nextCodeLine(KotlinJsr223JvmScriptEngineBase.kt:44)
	at org.jetbrains.kotlin.cli.common.repl.KotlinJsr223JvmScriptEngineBase.compileAndEval(KotlinJsr223JvmScriptEngineBase.kt:61)
	at org.jetbrains.kotlin.cli.common.repl.KotlinJsr223JvmScriptEngineBase.eval(KotlinJsr223JvmScriptEngineBase.kt:33)
	at org.springframework.cloud.contract.spec.internal.KotlinContractConverter$convertFrom$eval$1.invoke(KotlinContractConverter.kt:50)
	at org.springframework.cloud.contract.spec.internal.KotlinContractConverter$convertFrom$eval$1.invoke(KotlinContractConverter.kt:31)
	at org.springframework.cloud.contract.spec.internal.KotlinContractConverter.withUpdatedClassloader(KotlinContractConverter.kt:68)
	at org.springframework.cloud.contract.spec.internal.KotlinContractConverter.convertFrom(KotlinContractConverter.kt:46)
	at org.springframework.cloud.contract.verifier.file.ContractFileScanner.tryConvert(ContractFileScanner.groovy:308)
	at org.springframework.cloud.contract.verifier.file.ContractFileScanner.addContractToTestGeneration(ContractFileScanner.groovy:286)
	at org.springframework.cloud.contract.verifier.file.ContractFileScanner.appendRecursively(ContractFileScanner.groovy:253)
	at org.springframework.cloud.contract.verifier.file.ContractFileScanner.findContractsRecursively(ContractFileScanner.groovy:221)
	at org.springframework.cloud.contract.verifier.TestGenerator.generateTestClasses(TestGenerator.groovy:125)
	at org.springframework.cloud.contract.verifier.TestGenerator.generate(TestGenerator.groovy:104)
	at org.springframework.cloud.contract.verifier.plugin.GenerateServerTestsTask.generate(GenerateServerTestsTask.groovy:132)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at org.gradle.internal.reflect.JavaMethod.invoke(JavaMethod.java:103)
	at org.gradle.api.internal.project.taskfactory.StandardTaskAction.doExecute(StandardTaskAction.java:49)
	at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:42)
	at org.gradle.api.internal.project.taskfactory.StandardTaskAction.execute(StandardTaskAction.java:28)
	at org.gradle.api.internal.AbstractTask$TaskActionWrapper.execute(AbstractTask.java:717)
	at org.gradle.api.internal.AbstractTask$TaskActionWrapper.execute(AbstractTask.java:684)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter$5.run(ExecuteActionsTaskExecuter.java:476)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor$RunnableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:402)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor$RunnableBuildOperationWorker.execute(DefaultBuildOperationExecutor.java:394)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor$1.execute(DefaultBuildOperationExecutor.java:165)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.execute(DefaultBuildOperationExecutor.java:250)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.execute(DefaultBuildOperationExecutor.java:158)
	at org.gradle.internal.operations.DefaultBuildOperationExecutor.run(DefaultBuildOperationExecutor.java:92)
	at org.gradle.internal.operations.DelegatingBuildOperationExecutor.run(DelegatingBuildOperationExecutor.java:31)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeAction(ExecuteActionsTaskExecuter.java:461)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeActions(ExecuteActionsTaskExecuter.java:444)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.access$200(ExecuteActionsTaskExecuter.java:93)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter$TaskExecution.execute(ExecuteActionsTaskExecuter.java:237)
	at org.gradle.internal.execution.steps.ExecuteStep.lambda$execute$1(ExecuteStep.java:33)
	at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:33)
	at org.gradle.internal.execution.steps.ExecuteStep.execute(ExecuteStep.java:26)
	at org.gradle.internal.execution.steps.CleanupOutputsStep.execute(CleanupOutputsStep.java:58)
	at org.gradle.internal.execution.steps.CleanupOutputsStep.execute(CleanupOutputsStep.java:35)
	at org.gradle.internal.execution.steps.ResolveInputChangesStep.execute(ResolveInputChangesStep.java:48)
	at org.gradle.internal.execution.steps.ResolveInputChangesStep.execute(ResolveInputChangesStep.java:33)
	at org.gradle.internal.execution.steps.CancelExecutionStep.execute(CancelExecutionStep.java:39)
	at org.gradle.internal.execution.steps.TimeoutStep.executeWithoutTimeout(TimeoutStep.java:73)
	at org.gradle.internal.execution.steps.TimeoutStep.execute(TimeoutStep.java:54)
	at org.gradle.internal.execution.steps.CatchExceptionStep.execute(CatchExceptionStep.java:35)
	at org.gradle.internal.execution.steps.CreateOutputsStep.execute(CreateOutputsStep.java:51)
	at org.gradle.internal.execution.steps.SnapshotOutputsStep.execute(SnapshotOutputsStep.java:45)
	at org.gradle.internal.execution.steps.SnapshotOutputsStep.execute(SnapshotOutputsStep.java:31)
	at org.gradle.internal.execution.steps.CacheStep.executeWithoutCache(CacheStep.java:208)
	at org.gradle.internal.execution.steps.CacheStep.execute(CacheStep.java:70)
	at org.gradle.internal.execution.steps.CacheStep.execute(CacheStep.java:45)
	at org.gradle.internal.execution.steps.BroadcastChangingOutputsStep.execute(BroadcastChangingOutputsStep.java:49)
	at org.gradle.internal.execution.steps.StoreSnapshotsStep.execute(StoreSnapshotsStep.java:43)
	at org.gradle.internal.execution.steps.StoreSnapshotsStep.execute(StoreSnapshotsStep.java:32)
	at org.gradle.internal.execution.steps.RecordOutputsStep.execute(RecordOutputsStep.java:38)
	at org.gradle.internal.execution.steps.RecordOutputsStep.execute(RecordOutputsStep.java:24)
	at org.gradle.internal.execution.steps.SkipUpToDateStep.executeBecause(SkipUpToDateStep.java:96)
	at org.gradle.internal.execution.steps.SkipUpToDateStep.lambda$execute$0(SkipUpToDateStep.java:89)
	at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:54)
	at org.gradle.internal.execution.steps.SkipUpToDateStep.execute(SkipUpToDateStep.java:38)
	at org.gradle.internal.execution.steps.ResolveChangesStep.execute(ResolveChangesStep.java:76)
	at org.gradle.internal.execution.steps.ResolveChangesStep.execute(ResolveChangesStep.java:37)
	at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:36)
	at org.gradle.internal.execution.steps.legacy.MarkSnapshottingInputsFinishedStep.execute(MarkSnapshottingInputsFinishedStep.java:26)
	at org.gradle.internal.execution.steps.ResolveCachingStateStep.execute(ResolveCachingStateStep.java:90)
	at org.gradle.internal.execution.steps.ResolveCachingStateStep.execute(ResolveCachingStateStep.java:48)
	at org.gradle.internal.execution.steps.CaptureStateBeforeExecutionStep.execute(CaptureStateBeforeExecutionStep.java:69)
	at org.gradle.internal.execution.steps.CaptureStateBeforeExecutionStep.execute(CaptureStateBeforeExecutionStep.java:47)
	at org.gradle.internal.execution.impl.DefaultWorkExecutor.execute(DefaultWorkExecutor.java:33)
	at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:140)
	... 35 more
```