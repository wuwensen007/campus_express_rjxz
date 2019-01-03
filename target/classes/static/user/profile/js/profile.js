var vm = new Vue({
    el:'#app',
    data () {
        return {
            myid: getMyId(),
            mylevel: getMyLevel(),
            mysex: getMySex(),
            myphone: getMyPhone(),
            mypwd: getMyPwd(),
            mynickname: getMyNickname(),
            mycity: getMyCity(),
            mysignature: getMySignature(),
            myemail: getMyEmail(),
            myaddress: getMyAddress(),
            mypassword:'',
            mynewPwd:'',
            myconfirmPwd:'',
            tableData1: this.mockTableData1(),
            tableColumns1: [
                {
                    title: '订单id',
                    key: 'orderId'
                },
                {
                    title: '订单时间',
                    key: 'time'

                },
                {
                    title: '派送员',
                    key: 'courierId'

                },
                {
                    title: '状态',
                    key: 'state'

                }
            ]
        }
    },
    methods: {
        mockTableData1 () {



            let data = [];


            $.get("/user/getOrderBuyList", {userId: this.myid}, function (msg) {

                if (msg != null && msg != undefined) {

                    for (var i = 0; i < msg.length; i++){

                        var order_id = msg[i].id;
                        var courier_id = msg[i].courierid;
                        var _time = msg[i].time;
                        var _state;

                        if(courier_id == null || courier_id == undefined){
                            courier_id = '无',
                            _state = '正在等待处理';
                        }else {
                            _state = '处理中';
                        }

                        data.push({

                            orderId: order_id,
                            time: _time,
                            courierId: courier_id,
                            state: _state

                        });
                    }
                }
            });
            return data;
        },
        formatDate (date) {
            const y = date.getFullYear();
            let m = date.getMonth() + 1;
            m = m < 10 ? '0' + m : m;
            let d = date.getDate();
            d = d < 10 ? ('0' + d) : d;
            return y + '-' + m + '-' + d;
        },
        changePage () {

            this.tableData1 = this.mockTableData1();
        },
        //编辑个人中心
        confirmUpdate: function () {

            $.post("/user/updateProfile", {
                nickname: this.mynickname,
                address: this.myaddress,
                city: this.mycity,
                phone: this.myphone,
                sex: this.mysex,
                signature: this.mysignature,
                email: this.myemail
            }, function(data){

                if(data != null && data != undefined){
                    alert("修改成功")
                }
                //更新session里的account
                sessionStorage.setItem("account", JSON.stringify(data));

            });
        },
        //修改密码
        updatePassword: function(){

            if(this.mypassword != account.mypassword){
                alert("原密码错误");
                return;
            }

            if(this.mynewPwd == this.myconfirmPwd){
                //提交修改密码请求
                $.post("/user/updatePassword", {password: this.mynewPwd}, function(data){
                    if(data != null && data != undefined){
                        alert("修改成功");
                        //更新sessionStorage里的account
                        sessionStorage.setItem("account", JSON.stringify(data));

                    }else {
                        alert("修改失败")
                    }
                });
            }else {
                alert("两次输入的密码不一致,请重新输入!");
            }
        },
        //注销账号
        logout: function () {
            //从session中删除账号并将account=null
            sessionStorage.removeItem("account");
            this.myid = '';
            this.mylevel = '';
            this.mysex = '';
            this.myphone = '';
            this.mypwd = '';
            this.mynickname = '';
            this.mycity = '';
            this.mysignature = '';
            this.myemail = '';
            this.myaddress = '';

            $.get("/user/logout", function (data) {
                if(data == true){
                    alert("注销成功!!");
                    window.location.href = "/user/indexuser.html";
                }
            });
        }
    }
});

vm.mockTableData1();








