//登录
var loginForm = new Vue({
	
	el:"#login",
	data:{
		email: '',
		password: '',
		authCode: '',
		checked: false
	},
	methods:{
		
		login: function(){
			
			if (this.email.length == 0 || this.password.length == 0) {
    			this.help = '请将信息填写完整';
    			return;
    		}
   
    		//提交登录请求
	        $.get("/user/login",
                {email: this.email, password: this.password, checked: this.checked},
				function (data) {
	
	            if (data != null && data != undefined) {
	                sessionStorage.setItem("account", JSON.stringify(data));
	                alert("登录成功");
	                
	            } else {
	
	                alert("登录失败");
	            }
	        }, "json");

		},
		//生成验证码图片
		nextImg: function () {
            var img = document.getElementById("authCodeImg");
            var xhr = createRequest();
            xhr.open("GET","/getAuthCode",true);
            xhr.onload = function () {
                if(this.status == 200){
                    var blob = this.response;
                    img.src = window.URL.createObjectURL(blob);
                }
            };
            xhr.responseType = "blob";
            xhr.send(null);
       },
       //检查验证码
       checkAuthCode: function(){
       		$.get("/getAuthCodeStr", function (data) {
                if(this.authCode != data){
                    alert("验证码错误");
                }
            });
       }
	}
	
});

loginForm.nextImg();

//注册
var registerForm = new Vue({
	el: "#register",
	data:{
		username: '',
		emailsignup: '',
		passwordsignup: '',
		passwordsignup_confirm: '',
		verificationCode: '',
		emailCode: null
	},
	methods:{
	
		register: function(){
			
			if(username.length == 0 || emailsignup.length == 0 ||
					passwordsignup.length == 0 || passwordsignup_confirm.length == 0){	
				alert("请将信息填写完整!");
				return;
			}
			
			if(this.passwordsignup != this.passwordsignup_confirm){
				alert("前后密码输入不一致!");
				return;
			}
			
			$.post("/user/register",{username: this.username, email: this.emailsignup, password: this.passwordsignup} , function (data) {
	            if(data != null && data != undefined){
	                //将json对象转化为json字符串
	                sessionStorage.setItem("account", JSON.stringify(data));
	                alert("注册成功");
	            }else {
	                alert("注册失败");
	            }
        	});
		},
		//发送邮箱
		sendEmail: function(){
			
			$.get("/getEmailCode",{address: this.emailsignup, personal: this.emailsignup },function (data) {
	            sessionStorage.setItem("emailCode",data);
	            this.emailCode = sessionStorage.getItem("emailCode");
	        });
		}
		
	}
})