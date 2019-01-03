var order = new Vue({
    el:"#app",
    data:{
        orderView: 'orderBuyView'
    },
    components:{
        orderSendView:{
            template: `
                <div class="tab-pane fade in active" id="section2">
                    <form class="form-horizontal">
                        <h6 class="title">物品信息</h6>
                        <hr />
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="itemType">物品类型:</label>
                            <div class="col-lg-3">
                                <select class="form-control" id="itemType" v-model="itemType" > 	
                                    <option v-for="option in options" v-bind:value="option.value" v-html="option.text">                      
                                    </option>
                                </select>  
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="notes">备 注:</label>
                            <div class="col-lg-8">
                                <textarea class="form-control" id="notes" v-model="notes" rows="4"></textarea>
                            </div>
                        </div>
        
                        <h6 class="title">收货信息</h6>
                        <hr />
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="receiverAddr">收货地址:</label>
                            <div class="col-lg-9">
                                <div class="input-group input-group-md">
                                    <input id="receiverAddr" v-model="receiverAddr" class="form-control" type="text" placeholder="请填写收货地址"/>
                                    <btn type="button" class="input-group-addon btn btn-info" data-toggle="modal" data-target="#startMap">
                                        定位
                                    </btn>
                                </div>
                            </div>
                        </div>
        
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="receiverNoteAddr">备注地址:</label>
                            <div class="col-lg-9">
                                <input id="receiverNoteAddr" v-model="receiverNoteAddr" class="form-control" type="text" placeholder="请填写具体楼号及门牌号"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="control-label col-lg-2">收货电话:</label>
                            <div class=" col-lg-3">
                                <input id="phone" class="form-control" v-model="phone" maxlength="11" type="text" placeholder="请填写联系人手机号码" required/>
                            </div>
                        </div>
        
        
                        <h6 class="title">发货信息</h6>
                        <hr />
                        <div class="form-group">
                            <label for="sendAddr" class="control-label col-lg-2">发货地址:</label>
                            <div class="col-lg-9">
                                <div class="input-group input-group-md">
                                    <input id="sendAddr" v-model="sendAddr" type="text" class="form-control" placeholder="请填写发货地址"/>
                                    <btn type="button" class="input-group-addon btn btn-info" data-toggle="modal" data-target="#startMap">
                                        定位
                                    </btn>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sendNoteAddr" class="control-label col-lg-2">备注地址:</label>
                            <div class="col-lg-9">
                                <input type="text" class="form-control" id="sendNoteAddr" v-model="sendNoteAddr" placeholder="请填写具体楼号及门牌号"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <h6 class="title">确认信息</h6>	
                            <hr/>	
                            <label>距离:<span v-html="distance"></span></label><br>
                            <label>跑路费:<span v-html="tip"></span></label><br>
                            
                            <div class="container-fuild">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="myPhone" class="control-label col-lg-2">手机号码:</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" v-model="myPhone" id="myPhone" placeholder="请填写手机号码"/>
                                            </div>
                                        </div>
                                                   
                                        <div class="form-group">
                                            <label for="pictureCode" class="control-label col-lg-2">图片验证:</label>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <input type="text" id="pictureCode" class="form-control" placeholder="请填写验证码"/>
                                                    <span class="input-group-addon">	                    				
                                                        <img id="authCodeImg" height="25px" alt="加载中..."/>											
                                                    </span>	 
                                                    <btn type="button" class="input-group-addon btn btn-info">换一张</btn>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="SMSCode" class="control-label col-lg-2">短信验证:</label>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <input type="text" id="SMSCode" v-model="SMSCode" class="form-control" placeholder="验证码"/>
                                                    <btn type="button" class="input-group-addon btn btn-info">发送验证码</btn> 		                                   			                    
                                               </div>
                                            </div>	                                      			
                                        </div>
                                            
                                        <div class="form-group">
                                            <div class="col-lg-8">
                                                <input class="form-control btn btn-primary" type="button" v-on:click="submitOrder" value="确认订单"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="allmap" class="col-md-6">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            `,
            data:function () {
                return{
                    itemType: '其他',
                    options: [
                        { text: '其他', value: '其他'},
                        { text: '美食', value: '美食'},
                        { text: '文件', value: '文件'},
                        { text: '蛋糕', value: '蛋糕'},
                        { text: '鲜花', value: '鲜花'},
                        { text: '钥匙', value: '钥匙'},
                        { text: '手机', value: '手机'}
                    ],
                    notes: '',
                    receiverAddr: '',
                    receiverNoteAddr: '',
                    phone: '',
                    sendAddr: '',
                    sendNoteAddr: '',
                    distance: '',
                    tip: '',
                    myPhone: '',
                    SMSCode: ''
                }
            },
            methods:{
                //提交代送订单
                submitOrder: function(){

                    var account = JSON.parse(sessionStorage.getItem("account"));
                    if(account == null || account == undefined){
                        alert("请先登录或注册你的账号");
                        return;
                    }

                    $.post("/user/submitOrderSend",{
                        itemType: this.itemType,
                        notes: this.notes,
                        receiveAddr: this.receiveAddr,
                        receiverNoteAddr: this.receiverNoteAddr,
                        phone: this.phone,
                        sendAddr: this.sendAddr,
                        sendNoteAddr: this.sendNoteAddr
                    },function(data){

                        if(data == true){
                            alert("提交成功!");
                        }else{
                            alert("提交失败!");
                        }
                    });

                }
            }
        },
        orderTakeView:{
            template: `
                <div class="tab-pane fade in active" id="section3">
                    <form class="form-horizontal">
                        <h6 class="title">物品信息</h6>
                        <hr />
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="itemType">物品类型:</label>
                            <div class="col-lg-3">
                                <select class="form-control" id="itemType" v-model="itemType" > 	
                                    <option v-for="option in options" v-bind:value="option.value" v-html="option.text">                      
                                    </option>
                                </select>  
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="notes">备 注:</label>
                            <div class="col-lg-8">
                                <textarea class="form-control" id="notes" v-model="notes" rows="4"></textarea>
                            </div>
                        </div>
        
                        <h6 class="title">收货信息</h6>
                        <hr />
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="receiverAddr">收货地址:</label>
                            <div class="col-lg-9">
                                <div class="input-group input-group-md">
                                    <input id="receiverAddr" v-model="receiverAddr" class="form-control" type="text" placeholder="请填写收货地址"/>
                                    <btn type="button" class="input-group-addon btn btn-info" data-toggle="modal" data-target="#startMap">
                                        定位
                                    </btn>
                                </div>
                            </div>
                        </div>
        
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="receiverNoteAddr">备注地址:</label>
                            <div class="col-lg-9">
                                <input id="receiverNoteAddr" v-model="receiverNoteAddr" class="form-control" type="text" placeholder="请填写具体楼号及门牌号"/>
                            </div>
                        </div>
        
                        <h6 class="title">取货信息</h6>
                        <hr />
                        <div class="form-group">
                            <label for="takeAddr" class="control-label col-lg-2">取货地址:</label>
                            <div class="col-lg-9">
                                <div class="input-group input-group-md">
                                    <input id="takeAddr" v-model="takeAddr" type="text" class="form-control" placeholder="请填写取货地址"/>
                                    <btn type="button" class="input-group-addon btn btn-info" data-toggle="modal" data-target="#startMap">
                                        定位
                                    </btn>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="takeNoteAddr" class="control-label col-lg-2">备注地址:</label>
                            <div class="col-lg-9">
                                <input type="text" class="form-control" id="takeNoteAddr" v-model="takeNoteAddr" placeholder="请填写具体楼号及门牌号"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="control-label col-lg-2">取货电话:</label>
                            <div class=" col-lg-3">
                                <input id="phone" v-model="phone" class="form-control" maxlength="11" type="text" placeholder="请填写联系人手机号码" required/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <h6 class="title">确认信息</h6>	
                            <hr/>	
                            <label>距离:<span v-html="distance"></span></label><br>
                            <label>跑路费:<span v-html="tip"></span></label><br>
                            
                            <div class="container-fuild">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="myPhone" class="control-label col-lg-2">手机号码:</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" v-model="myPhone" id="myPhone" placeholder="请填写手机号码"/>
                                            </div>
                                        </div>
                                                   
                                        <div class="form-group">
                                            <label for="pictureCode" class="control-label col-lg-2">图片验证:</label>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <input type="text" id="pictureCode" class="form-control" placeholder="请填写验证码"/>
                                                    <span class="input-group-addon">	                    				
                                                        <img id="authCodeImg" height="25px" alt="加载中..."/>											
                                                    </span>	 
                                                    <btn type="button" class="input-group-addon btn btn-info">换一张</btn>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="SMSCode" class="control-label col-lg-2">短信验证:</label>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <input type="text" id="SMSCode" v-model="SMSCode" class="form-control" placeholder="验证码"/>
                                                    <btn type="button" class="input-group-addon btn btn-info">发送验证码</btn> 		                                   			                    
                                               </div>
                                            </div>	                                      			
                                        </div>
                                            
                                        <div class="form-group">
                                            <div class="col-lg-8">
                                                <input class="form-control btn btn-primary" type="button" v-on:click="submitOrder" value="确认订单"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="allmap" class="col-md-6">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            `,
            data:function () {
                return {
                    itemType: '其他',
                    options: [
                        { text: '其他', value: '其他'},
                        { text: '美食', value: '美食'},
                        { text: '文件', value: '文件'},
                        { text: '蛋糕', value: '蛋糕'},
                        { text: '鲜花', value: '鲜花'},
                        { text: '钥匙', value: '钥匙'},
                        { text: '手机', value: '手机'}
                    ],
                    notes: '',
                    receiverAddr: '',
                    receiverNoteAddr: '',
                    phone: '',
                    takeAddr: '',
                    takeNoteAddr: '',
                    distance: '',
                    tip: '',
                    myPhone: '',
                    SMSCode: ''
                }
            },
            methods:{
                //提交代取订单
                submitOrder: function(){

                    var account = JSON.parse(sessionStorage.getItem("account"));
                    if(account == null || account == undefined){
                        alert("请先登录或注册你的账号");
                        return;
                    }

                    $.post("/user/submitOrderTake",{
                        itemType: this.itemType,
                        notes: this.notes,
                        receiveAddr: this.receiveAddr,
                        receiverNoteAddr: this.receiverNoteAddr,
                        phone: this.phone,
                        takeAddr: this.sendAddr,
                        takeNoteAddr: this.sendNoteAddr
                    },function(data){

                        if(data == true){
                            alert("提交成功!");
                        }else{
                            alert("提交失败!");
                        }
                    });
                }
            }
        },
        orderBuyView: {
            template: `
                <div class="tab-pane fade in active" id="section1">
                    <form class="form-horizontal">
                        <h6 class="title">物品信息</h6>
                        <hr />
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="buyContent">购买类容:</label>
                            <div class="col-lg-3">
                                <select class="form-control" id="buyContent" v-model="buyContent">
                                    <option v-for="option in options" v-bind:value="option.value" v-html="option.text">
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="commodityPrices">商品价格:</label>
                            <div class="col-lg-3">
                                <div class="input-group">
                                    <input class="form-control" type="text" id="commodityPrices" v-model="commodityPrices"/>
                                    <span class="input-group-addon">元</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="notes">备 注:</label>
                            <div class="col-lg-8">
                                <textarea class="form-control" id="notes" rows="4" v-model="notes"></textarea>
                            </div>
                        </div>
        
                        <h6 class="title">收件信息</h6>
                        <hr />
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="receiverAddr">收货地址:</label>
                            <div class="col-lg-9">
                                <div class="input-group input-group-md">
                                    <input id="receiverAddr" v-model="receiverAddr" class="form-control" type="text" placeholder="请填写收货地址"/>
                                    <btn type="button" class="input-group-addon btn btn-info" data-toggle="modal" data-target="#startMap">定位</btn>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="receiverNoteAddr">备注地址:</label>
                            <div class="col-lg-9">
                                <input id="receiverNoteAddr" v-model="receiverNoteAddr" class="form-control" type="text" placeholder="请填写具体楼号及门牌号"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="control-label  col-lg-2">收货电话:</label>
                            <div class=" col-lg-3">
                                <input id="phone" class="form-control" v-model="phone" maxlength="11" type="text" placeholder="请填写联系人手机号码" required/>
                            </div>
                        </div>
        
        
                        <h6 class="title">购买信息</h6>
                        <hr />
                        <div class="form-group">
                            <label for="buyAddr" class="control-label col-lg-2">购买地址:</label>
                            <div class="col-lg-9">
                                <div class="input-group input-group-md">
                                    <input id="buyAddr" v-model="buyAddr" type="text" class="form-control" placeholder="请输入购买地址"/>
                                    <btn type="button" class="input-group-addon btn btn-info" data-toggle="modal" data-target="#endMap">定位</btn>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-lg-2" for="buyNoteAddr">备注地址:</label>
                            <div class="col-lg-9">
                                <input id="buyNoteAddr" v-model="buyNoteAddr" class="form-control" type="text" placeholder="请填写具体楼号及门牌号"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="demand" class="control-label col-lg-2">购买要求:</label>
                            <div class=" col-lg-9">
                                <textarea class="form-control" id="demand" v-model="demand" rows="3" placeholder="请输入商品名称和数量等"></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <h6 class="title">确认信息</h6>	
                            <hr/>	
                            <label>距离:<span v-html="distance"></span></label><br>
                            <label>跑路费:<span v-html="tip"></span></label><br>
                            
                            <div class="container-fuild">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="myPhone" class="control-label col-lg-2">手机号码:</label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" v-model="myPhone" id="myPhone" placeholder="请填写手机号码"/>
                                            </div>
                                        </div>
                                                   
                                        <div class="form-group">
                                            <label for="pictureCode" class="control-label col-lg-2">图片验证:</label>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <input type="text" id="pictureCode" class="form-control" placeholder="请填写验证码"/>
                                                    <span class="input-group-addon">	                    				
                                                        <img id="authCodeImg" height="25px" alt="加载中..."/>											
                                                    </span>	 
                                                    <btn type="button" class="input-group-addon btn btn-info">换一张</btn>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="SMSCode" class="control-label col-lg-2">短信验证:</label>
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <input type="text" id="SMSCode" v-model="SMSCode" class="form-control" placeholder="验证码"/>
                                                    <btn type="button" class="input-group-addon btn btn-info">发送验证码</btn> 		                                   			                    
                                               </div>
                                            </div>	                                      			
                                        </div>
                                            
                                        <div class="form-group">
                                            <div class="col-lg-8">
                                                <input class="form-control btn btn-primary" type="button" v-on:click="submitOrder" value="确认订单"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="allmap" class="col-md-6">
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            `,
            data: function () {
                return {
                    buyContent: '随意购',
                    options: [
                        {text: '随意购', value: '随意购'},
                        {text: '咖啡', value: '咖啡'},
                        {text: '香烟', value: '香烟'},
                        {text: '酒', value: '酒'},
                        {text: '早餐', value: '早餐'},
                        {text: '宵夜', value: '宵夜'},
                        {text: '药品', value: '药品'},
                        {text: '生鲜', value: '生鲜'}
                    ],
                    commodityPrices: '',
                    receiverAddr: '',
                    receiverNoteAddr: '',
                    phone: '',
                    notes: '',
                    buyAddr: '',
                    buyNoteAddr: '',
                    demand: '',
                    distance: '',
                    tip: '',
                    myPhone: '',
                    SMSCode: ''
                }
            },
            methods: {
                submitOrder: function () {

                    var account = JSON.parse(sessionStorage.getItem("account"));
                    if (account == null || account == undefined) {
                        alert("请先登录或注册你的账号");
                        return;
                    }

                    //提交代买订单
                    $.post("/user/submitOrderBuy", {
                        buyContent: this.buyContent,
                        commodityPrices: this.commodityPrices,
                        receiverAddr: this.receiverAddr,
                        receiverNoteAddr: this.receiverNoteAddr,
                        phone: this.phone,
                        notes: this.notes,
                        buyAddr: this.buyAddr,
                        buyNoteAddr: this.buyNoteAddr,
                        demand: this.demand
                    }, function (data) {
                        if (data == true) {
                            alert("提交成功!");
                        } else {
                            alert("提交失败!");
                        }
                    });
                }
            }
        }
    }

});

