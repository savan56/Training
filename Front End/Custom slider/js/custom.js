// Slidr 
// ======
var id = 1;
var $carousel = $('.carousel').flickity({
    imagesLoaded: true,
    percentPosition: false,
    initialIndex: 0,
});

var $imgs = $carousel.find('.carousel-cell img');

var docStyle = document.documentElement.style;
var transformProp = typeof docStyle.transform == 'string' ?
    'transform' : 'WebkitTransform';

var flkty = $carousel.data('flickity');

// slider auto play time
// ======================
var $carousel = $('.carousel').flickity({
    autoPlay: 1000
});

$(window).on('load', function() {

    // make slider auto play
    $carousel.flickity('playPlayer');

    // Appending Slide
    // ===============
    var fname
    var ext

    //loading array
    var users = JSON.parse(localStorage.getItem("users") || "[]");

    //traversing array
    users.forEach(function({ fileName, str }, index) {
        console.log("[" + index + "]: " + fileName);
        fname = fileName;
        caption = str;

        ext = fname.split('.').pop().toLowerCase();

        var imgExt = ['jpg', 'jpeg', 'png', 'bmp', 'gif'];
        var vidExt = ['mp4', 'mkv'];

        if (fname != null && ext != null) {
            var $cellElems = $(makeCellHtml());
            $carousel.flickity('append', $cellElems);
        }

        var cellCount = 0;

        function makeCellHtml() {
            cellCount++;
            if (vidExt.lastIndexOf(ext) != -1) {
                return '<div class="carousel-cell" id="' + id + '"><video controls autoplay loop><source src="video/' + fileName + '" type="video/mp4"></video></div>';
            } else if (imgExt.lastIndexOf(ext) != -1) {
                return '<div class="carousel-cell" id="' + id + '"><div class="static-banner static-banner1 caption" id= "demo' + id + '"></div><img src="img/' + fileName + '"></img></div>';
            } else {
                alert("Image and video File only");
            }
        }

        //text Over image
        // ===============
        if (caption != null) {
            $("#demo" + id).html(caption);
            id++;
        };
    });

});