function createRequest() {
    try{
        request = new XMLHttpRequest();
    }catch (e) {
        try{
            request = new ActiveXObject("Msxml2.XMLHTTP");
        }catch (e) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            }catch (e) {
                request = null;
            }
        }
    }
    return request;
}