$(function () {


});

function loginSubmit() {
    var username = $("#username").val();
    var password = $("#password").val();

    var user = {
        username: username,
        password: password
    };

    $.ajax({
        url : "login",
        type:"post",
        data: user,
        success : function(data){
            if( data!=null ){
                console.info("success");
                console.info(ctx);
                window.location.href = ctx + "/indexUI";
            }
        },
        error: function (data) {
            console.info("error");
        }
    });
}

