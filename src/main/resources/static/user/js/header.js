Vue.component("my-header",{

	data:function(){

		return{

			email: JSON.parse(sessionStorage.getItem("account")) == null || JSON.parse(sessionStorage.getItem("account")) == undefined ? '' : JSON.parse(sessionStorage.getItem("account")).email,
			password: '',
            isShow : JSON.parse(sessionStorage.getItem("account")) == null || JSON.parse(sessionStorage.getItem("account")) == undefined ? true : false

		}
	},
	methods:{

		login: function(){

            if (this.email.length == 0 || this.password.length == 0) {
                alert('请将信息填写完整');
                return;
            }

            var _this = this;

            //提交登录请求
            $.get("/user/login",
                {email: this.email, password: this.password, checked: this.checked},
                function (data) {

                    alert(data);

                    alert(JSON.stringify(data));

                    if (data != null && data != undefined) {
                        sessionStorage.removeItem("account");
                        sessionStorage.setItem("account", JSON.stringify(data));
                        alert(sessionStorage.getItem("account"));
                        alert("登录成功");
                        _this.isShow = false;

                    }else{
                        alert("登录失败");
                    }
                }, "json");

		},
        //注销账号
        logout: function () {

            //从session中删除账号
            sessionStorage.removeItem("account");

            var _this = this;

            $.get("/user/logout", function (data) {
                if(data == true){
                    _this.isShow = true;
                }
            });
        }
	},
    template:`
	<header class="header container-fuild row fixed-top" xmlns="http://www.w3.org/1999/html">

        <div class="col-sm-8 header-left">
            <div class="logo">
                <a href="indexuser.html"><img src="img/logo123.png" alt=""/></a>
            </div>

            <div class="menu">
                <ul id="nav">
                    <li class="active"><a href="indexuser.html">首页</a></li>
                    <li><a href="order.html">在线订单</a></li>
                    <li><a href="job.html">成为骑士</a></li>
                    <li><a href="about.html">关于我们</a></li>
                    <li><a href="404.html">下载APP</a></li>          
                </ul>
            </div>
            <!--搜索框-->
            
            <div class="search-box" v-show = "isShow">
				<div id="sb-search" class="sb-search">
					<form>
						<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
						<input class="sb-search-submit" type="submit" value="">
						<span class="sb-icon-search"> </span>
					</form>
				</div>
			</div>
        </div>
       
        <div class="col-sm-4 header_right" v-show = "isShow">
    
            <div id="loginContainer"><a href="#" id="loginButton"><img src="img/login.png"><span>登录及注册</span></a>
                <div id="loginBox">
                    <form id="loginForm">
                        <fieldset id="body">
                            <fieldset>
                                  <label for="username">邮箱号:</label>
                                  <input type="text" v-model="email" id="username" placeholder="输入邮箱号">
                            </fieldset>
                            <fieldset>
                                    <label for="password">密码:</label>
                                    <input type="password" v-model="password" id="password" placeholder="输入密码">
                             </fieldset>
                            <input type="button" id="login" v-on:click="login" value="Sign in">
                            <span><a href="rl.html">注册</a></span>
                            <label for="checkbox"><input type="checkbox" v-model="checked" id="checkbox"> <i>Remember me</i></label>
                        </fieldset>
                        <span><a href="#">Forgot your password?</a></span>
                       
                    </form>
                </div>
            </div> 
        </div>
        <div id="welcomeDiv" v-show = "!isShow">
        
            <div class="dropdown show">
                <a class="btn btn-success dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span>您好,&nbsp;{{email}}</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href='profile/index.html'>个人中心</a>
                    <a class="dropdown-item" @click="logout" href="##">退出</a>
                </div>
            </div>
        
        </div> 
        
    </header>
	`
});

