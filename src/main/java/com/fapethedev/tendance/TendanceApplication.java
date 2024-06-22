package com.fapethedev.tendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TendanceApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TendanceApplication.class, args);
	}

//	@Bean
//	@Autowired
//	public FlywayMigrationStrategy flywayMigrationStrategy(SentryAlertMonitor alertMonitor)
//	{
//		return (flywayOld) ->
//		{
//			try
//			{
//				Flyway flyway = Flyway.configure()
//						.configuration(flywayOld.getConfiguration())
//						.load();
//
//				flyway.baseline();
//				flyway.migrate();
//			}
//			catch (Exception e) {
//				alertMonitor.captureException(e);
//			}
//		};
//	}
}
