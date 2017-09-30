$(function () {
    // do nothing
});

/**
 * 简单发送
 */
function sendEmail() {
    var address = $("#address").val();
    var sendPerson = $("#sendPerson").val();

    var params = {
        address: address,
        sendPerson: sendPerson
    };

    $.ajax({
        url : "sendEmail",
        type:"post",
        data: params,
        success : function(data){
            if( data!==null ){
                console.info(data);
                if ( data.code==="10000" ){
                    layer.alert('猜猜你发送成功了吗？', {
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0
                    }, function(){
                        layer.alert('好吧，你成功了', {
                            skin: 'layui-layer-lan'
                            ,closeBtn: 0
                            ,anim: 4 //动画类型
                        });
                    });
                }
            }
        },
        error: function (data) {
            console.info("error");
        }
    });
}

/**
 * 通过模板发送
 */
function sendEmailByFreemarker() {
    var address = $("#address").val();
    var sendPerson = $("#sendPerson").val();

    var params = {
        address: address,
        sendPerson: sendPerson
    };

    $.ajax({
        url : "sendEmailByFreemarker",
        type:"post",
        data: params,
        success : function(data){
            if( data!==null ){
                console.info(data);
                if ( data.code==="10000" ){
                    layer.alert('猜猜你发送成功了吗？', {
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0
                    }, function(){
                        layer.alert('好吧，你成功了', {
                            skin: 'layui-layer-lan'
                            ,closeBtn: 0
                            ,anim: 4 //动画类型
                        });
                    });
                }
            }
        },
        error: function (data) {
            console.info("error");
        }
    });
}

function resetSendEmail() {
    $("#address").val("");
    $("#sendPerson").val("");
}