package com.rameshbabuiiit.moveme;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Random;

public class MoveMe {
	public static final int SLEEP_MILLIS = 60000;
	public static Integer DURATION;
	public static final int MAX_Y = 800;
	public static final int MAX_X = 800;

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.out.println("CopyRights Reserved -> ramsusid@gmail.com");
		Boolean stopFlag = false;
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties prop = new Properties();
			prop.load(input);
			DURATION = Integer.parseInt(prop.getProperty("cursor.movement.duration.minutes"));
		} catch (Exception ex) {
			System.out
					.println("cursor.movement.duration.minutes, cursor.movement.stop not found in config.properties!");
			DURATION = 480;
		}

		Robot robot = new Robot();
		Random random = new Random();
		Integer duration = DURATION;

		for (int i = 0; i < duration; i++) {
			try (InputStream input = new FileInputStream("config.properties")) {
				Properties prop = new Properties();
				prop.load(input);
				stopFlag = Boolean.parseBoolean(prop.getProperty("cursor.movement.stop"));
			} catch (Exception ex) {
				ex.getStackTrace();
			}
			if (stopFlag) {
				System.out.println("cursor.movement.stop flag is true. Stopping the program!");
				break;
			}
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			System.out.println(LocalDateTime.now() + ": Seleeping minute:" + i);
			Thread.sleep(SLEEP_MILLIS);
		}
	}

}
