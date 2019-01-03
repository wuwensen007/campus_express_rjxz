
Vue.component("my-footer",{
	template:`
	<footer class="footer fix-bottom">
		<div class="container">
			<div class="footer_top">
				<h3>Subscribe to our newsletter</h3>
				<form>
					<span>
					<i><img src="img/mail.png" alt=""></i>
				    <input type="text" value="Enter your email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter your email';}">
				    <label class="btn1 btn2 btn-2 btn-2g"> <input name="submit" type="submit" id="submit" value="Subscribe"> </label>
				    <div class="clearfix"> </div>
					</span>
				</form>
			</div>
			<div class="footer_grids">
				<div class="footer-grid">
					<h4>关于我们</h4>
					<ul class="list1">
						<li>
							<a href="#">首页</a>
						</li>
						<li>
							<a href="#">校园快递介绍</a>
						</li>
						<li>
							<a href="#">服务宗旨</a>
						</li>
						<li>
							<a href="#">联系我们</a>
						</li>
						<li>
							<a href="#">其它 </a>
						</li>
					</ul>
				</div>
				<div class="footer-grid">
					<h4>意见反馈</h4>
					<ul class="list1">
						<li>
							<a href="#">常见问题</a>
						</li>
						<li>
							<a href="#">如何下单</a>
						</li>
						<li>
							<a href="#">如何付款 </a>
						</li>
						<li>
							<a href="#">如何开具发票</a>
						</li>
						<li>
							<a href="#">其它</a>
						</li>
					</ul>
				</div>
				<div class="footer-grid">
					<h4>网站导航</h4>
					<ul class="list1">
						<li>
							<a href="#">在线下单</a>
						</li>
						<li>
							<a href="#">加盟招商</a>
						</li>
						<li>
							<a href="#">加入我们 </a>
						</li>
						<li>
							<a href="#">开放平台</a>
						</li>
						<li>
							<a href="#">其它</a>
						</li>
					</ul>
				</div>
				
				<div class="footer-grid">
					<h4>Follow Us</h4>
					<ul class="footer_social wow fadeInLeft" data-wow-delay="0.4s">
						<li>
							<a href=""> <i class="fb"> </i> </a>
						</li>
						<li>
							<a href=""><i class="tw"> </i> </a>
						</li>
						<li>
							<a href=""><i class="google"> </i> </a>
						</li>
						<li>
							<a href=""><i class="u_tube"> </i> </a>
						</li>
					</ul>
					<div class="copy wow fadeInRight" data-wow-delay="0.4s">
						<p>Copyright &copy; 2018.软件小组software boys版权所有
							<a href="#" target="_blank" title="软件小组">软件小组</a>

						</p>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</footer>
	`
});
