function updateGH() {
    $("#column_right").load("columnRight.aspx");
    ScrollCart();
}

function themVaoGH(a,b) {
    var request = $.ajax({
        url: "giohang.aspx",
        type: "POST",
        data: { MALK: a, SoLuong: b, method: 'add' },
        success: function (response, textStatus, jqXHR) {
            // log a message to the console
            var image = $('#img' + a).offset();
            var cart = $('#module_cart').offset();
            $("#temp").stop(true, true);
            $("#temp").remove();
            $('#img' + a).before('<img src="' + $('#img' + a).attr('src') + '" id="temp" style="z-index:100; position: absolute; top: ' + image.top + 'px; left: ' + image.left + 'px;" />');

            params = {
                top: cart.top + 'px',
                left: cart.left + 'px',
                opacity: 0.0,
                width: $('#module_cart').width(),
                heigth: $('#module_cart').height()
            };

            $('#temp').animate(params, 1500, false, function () {
                $('#temp').remove();
                updateGH();
            });
            /*$(".ErrorMes").stop().css("opacity", "1");
            $(".ErrorMes").html(response).fadeOut(3000, function () { $(this).html(""); $(this).toggle(); updateGH(); });*/

        },
        // callback handler that will be called on error
        error: function (jqXHR, textStatus, errorThrown) {
            // log the error to the console
            $(".ErrorMes").html(textStatus);
        },
        // callback handler that will be called on completion
        // which means, either on success or error
        complete: function () {
            // enable the inputs
        }
    });
}