package  com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	System.setProperty("webdriver.chrome.driver", "/Users/liruyi/selenium/chromedriver");
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://baijiahao.baidu.com/builder/app/login");
    	
    	/*PhantomJSDriver driver = new PhantomJSDriver();
    	driver.get("http://baijiahao.baidu.com/builder/app/login");*/
    	
    	  
    	WebElement username = driver.findElement(By.id("TANGRAM__PSP_4__userName"));  
    	WebElement password = driver.findElement(By.id("TANGRAM__PSP_4__password"));  
    	WebElement login_btn = driver.findElement(By.id("TANGRAM__PSP_4__submit"));  
    	
    	username.sendKeys("zgdfrog8");
    	password.sendKeys("gkdog8F");
    	login_btn.click();
    	
    	/*发布内容*/
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("publish")));
    	WebElement publish_content_btn = driver.findElement(By.className("publish"));
    	publish_content_btn.click();
    	
    	/*标题*/
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("article-title")));
    	WebElement title = driver.findElement(By.id("article-title"));
    	title.sendKeys("一二三四五六七八九");
    	
    	System.out.println(driver.getWindowHandle());
    	
    	/*上传图片*/
    	WebElement upload = driver.findElement(By.id("edui66_body"));
    	upload.click();
    	
    	//edui60_iframe
    	/*上传图片*/
    	driver.switchTo().frame("edui60_iframe");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='filePickerReady']/div[2]/input[@type='file']")));
    	WebElement choose_image= driver.findElement(By.xpath("//div[@id='filePickerReady']/div[2]/input[@type='file']"));
    	choose_image.sendKeys("/Users/liruyi/Downloads/libingbing.jpeg");
    	//choose_image_btn.click();
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='WU_FILE_0']/span")));
    	
    	/*点击确认按钮*/
    	driver.switchTo().defaultContent();
    	WebElement choose_image_btn = driver.findElement(By.xpath("//div[@id='edui65_body']/div[2]"));
    	choose_image_btn.click();
    	
    	WebElement cate_level = driver.findElement(By.id("cate-level-1"));
    	new Select(cate_level).selectByValue("4");
    	
    	
    	//*[@id="content"]/article/div[2]/div[2]/div[1]/div[4]/div[2]/div[1]/div/label[2]
    	driver.findElement(By.xpath("//*[@id='content']/article/div[2]/div[2]/div[1]/div[4]/div[2]/div[1]/div/label[2]")).click();
    	// media-img-cropper cover1
    	// data-num
    	WebElement data_num_1 = driver.findElement(By.xpath("//div[@data-num='1']"));
    	data_num_1.click();
    	
    	Thread.sleep(3000L);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select-img-modal']/div/div/div[2]/div/div/ul/li[1]")));
    	WebElement choose_element = driver.findElement(By.xpath("//*[@id='select-img-modal']/div/div/div[2]/div/div/ul/li[1]"));
    	choose_element.click();
    
    	WebElement button = driver.findElement(By.xpath("//*[@id='select-img-modal']/div/div/div[3]/button"));
    	button.click();
    	
    	Thread.sleep(3000L);
    	driver.findElement(By.xpath("//*[@id='universal-popup']/div[3]/div[2]")).click();
    	
    	//WebElement element = driver.findElement(By.name("passwd"));  
    	//WebElement element = driver.findElement(By.xpath("//input[@id='passwd-id']"));
    	
    	//editor-draft
    	Thread.sleep(3000L);
    	driver.findElement(By.id("editor-draft")).click();
    	
    }
}