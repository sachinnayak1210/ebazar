package utils;

public class EmailFormats{
	public static String getEmailVerificationMessage(String userName,String email,String verfCode){
		return "<div style='width: 80%;margin: 20px auto;border: 1px solid #bbb;'>"+
	"<div style='height: 70px;background-color: #f37652;position: relative;'>"+
		"<span style='position: absolute;left: 30px;top: 10px;font-size: 32px;font-weight: bold;color: white;font-family: verdana;'>eShop</span>"+
	"</div>"+
	"<div style='width: 90%;margin: 20px auto;font-family: verdana;'>"+
		"<span>Hello! "+userName+"<br /><br /><a href='http://localhost:8080/eshop/verifyme.do?email="+email+"&verification_code="+verfCode+"'>Click over the link to activate your account!</a></span>"+
	"</div>  </div>";
	}
}