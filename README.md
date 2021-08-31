# DependencyDelivery

>  结论:
>  1.当当前模块引用其他依赖时无论使用implementation 或者 api 都不影响当前模块使用依赖的内容
>  2.implementation会阻止当前模块将其依赖向下传递 对应 case4
>  3.api会将当前模块的依赖传递给调用者模块 对比case1 case2
