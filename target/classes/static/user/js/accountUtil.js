//返回账号对象
function getAccount() {

    var account = JSON.parse(sessionStorage.getItem("account"));

    if(account == null || account == undefined){
        return null;
    }else {
        return account;
    }

}

//返回账号对象的长度
function getAccountLen() {

    var account = getAccount();
    if(account != null){
        return account.length;
    }else {
        return 0;
    }

}


function getMyId() {
    return getAccountLen() == 0 ? '' : getAccount().id;
}

function getMyLevel() {
    return getAccountLen() == 0 ? '' : getAccount().level;
}

function getMySex() {
    return getAccountLen() == 0 ? '' : getAccount().sex;
}

function getMyPhone() {
    return getAccountLen() == 0 ? '' : getAccount().phone;
}

function getMyPwd() {
    return getAccountLen() == 0 ? '' : getAccount().password;
}

function getMyNickname() {
    return getAccountLen() == 0 ? '' : getAccount().nickname;
}

function getMyCity() {
    return getAccountLen() == 0 ? '' : getAccount().city;
}

function getMySignature() {
    return getAccountLen() == 0 ? '' : getAccount().signature;
}

function getMyEmail() {
    return getAccountLen() == 0 ? '' : getAccount().email;
}

function getMyAddress() {
    return getAccountLen() == 0 ?'' : getAccount().address;
}