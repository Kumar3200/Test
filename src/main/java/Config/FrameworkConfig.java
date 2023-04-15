//package Config;
//
//import org.aeonbits.owner.Config;
//
//@Config.LoadPolicy(Config.LoadType.MERGE)
//@Config.Sources({
//		"system:properties",
//		"system:env",
//		"file:${user.dir}/src/test/resources/config.properties"})
//public interface FrameworkConfig extends Config{
//	@DefaultValue("cop")
//	String environment();
//	
//	String path();
//	
//	@Key("${environment}.username")
//	String username();
//	
//	@Key("${environment}.password")
//	String password();
//	
//	@Key("${environment}.url")
//	String url();
//	
//	@Key("${environment}.reserve")
//	String reserve();
//
//}
