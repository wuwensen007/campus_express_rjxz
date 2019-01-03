var vm2 = new Vue({
    el: "#app",
	data:{
    	currentView: 'buyGood'
	},
    components:{
        sendGood:{
            template:`
				<ul class="row mystep">
					<li class="col">
						<div>
							<img id="flow1Pic" src="img/send_help1.png" width="270px" height="329px" alt="" />
							<p><strong>1.</strong>联系收货人<br/>确认发货地点和物品规格</p>
						</div>
					</li>
					<li  class="col">
						<div>
							<img id="flow2Pic" src="img/send_help2.png" width="270px" height="329px" alt="" />
							<p><strong>2.</strong>前往发货地点取货<br/>对物品拍照留证</p>
						</div>
	
					</li>
					<li class="col">
						<div>
							<img id="flow3Pic" src="img/send_help3.png" width="270px" height="329px" alt="" />
							<p><strong>3.</strong>取货后联系收货人<br/>确认收货时间和地点</p>
						</div>
	
					</li>
					<li class="col">
						<div>
							<img src="img/get.png" width="270px" height="329px" alt="" />
							<p><strong>4.</strong>前往发货地点<br/>按时到达,完成上门服务</p>
						</div>
					</li>
				</ul>
				`
        },
        buyGood:{
            template: `
				<ul class="row mystep">
					<li  class="col">
						<div>
							<img id="flow1Pic" src="img/buy_help1.png" width="270px" height="329px" alt="" />
							<p><strong>1.</strong>联系下单人<br/>确认购买地点和购买要求</p>
						</div>
					</li>
					<li  class="col">
						<div>
							<img id="flow2Pic" src="img/buy_help2.png" width="270px" height="329px" alt="" />
							<p><strong>2.</strong>前往指定地点购买<br/>并索要购物小票</p>
						</div>
	
					</li>
					<li class="col">
						<div>
							<img id="flow3Pic" src="img/buy_help3.png" width="270px" height="329px" alt="" />
							<p><strong>3.</strong>购物成功后联系收货人<br/>确认收货地点和收货时间</p>
						</div>
	
					</li>
					<li class="col">
						<div>
							<img src="img/get.png" width="270px" height="329px" alt="" />
							<p><strong>4.</strong>前往收货地点<br/>按时到达并完成</p>
						</div>
					</li>
				</ul>	
			`
        },
        takeGood:{
            template:`
				<ul class="row mystep">
					<li  class="col">
						<div>
							<img id="flow1Pic" src="img/take_help1.png" width="270px" height="329px" alt="" />
							<p><strong>1.</strong>联系收货人<br/>确认发货地点和物品规格</p>
						</div>
					</li>
					<li  class="col">
						<div>
							<img id="flow2Pic" src="img/take_help2.png" width="270px" height="329px" alt="" />
							<p><strong>2.</strong>前往发货地点取货<br/>对物品拍照留证</p>
						</div>
	
					</li>
					<li class="col">
						<div>
							<img id="flow3Pic" src="img/take_help3.png" width="270px" height="329px" alt="" />
							<p><strong>3.</strong>取货后联系收货人<br/>确认收货时间和地点</p>
						</div>
	
					</li>
					<li class="col">
						<div>
							<img src="img/get.png" width="270px" height="329px" alt="" />
							<p><strong>4.</strong>前往发货地点<br/>按时到达,完成送货</p>
						</div>
					</li>
				</ul>	
			`
        }
    }
});






