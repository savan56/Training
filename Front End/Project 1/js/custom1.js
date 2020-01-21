// Global Variable
// =================
var $carousel = $('.carousel').flickity({});
var id = 1;
var fileName
var ext
var str

// Selecting File
// ===============


$('input[type="file"]').change(function(e) {
    fileName = e.target.files[0].name;
    ext = fileName.split('.').pop().toLowerCase();
});



//text Over image
// ===============
$("#myBtn").click(function() {
    str = $("#myInput").val();
    id++;
});


// localstorage Array
// ====================
$('.button--append').on('click', function() {
    // Loading
    var users = JSON.parse(localStorage.getItem("users") || "[]");
    console.log("# of users: " + users.length);

    users.push({ fileName, str });
    console.log("Added user #" + fileName);

    // Saving
    localStorage.setItem("users", JSON.stringify(users));

    location.reload(true);
});


// Preview Items
// ==============
$(window).on('load', function() {
    $add();
});


// Appending Slide for Preview
// ============================
$add = function() {

    var fname
    var ext
    var index

    //loading array
    var users = JSON.parse(localStorage.getItem("users") || "[]");

    //traversing array
    users.forEach(function({ fileName, str }, index) {
        fname = fileName;

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
                $("#preview").append('<video controls><source src="video/' + fname + '" type="video/mp4"></video>' + fname + '<i id="delete' + index + '" class="fa fa-trash remove" aria-hidden="true"></i><hr>');
            } else if (imgExt.lastIndexOf(ext) != -1) {
                $("#preview").append('<img src="img/' + fname + '"/>' + fname + '<i id="delete' + index + '" class="fa fa-trash " aria-hidden="true"></i><hr>');
            } else {
                alert("Image and video File only");
            }
        }
        // Remove Slide
        // =============
        $('#delete' + index).on('click', function() {
            var result = confirm("Want to delete?");
            if (result) {
                var users1 = JSON.parse(localStorage.getItem("users") || "[]");
                localStorage.clear("users");
                users1.splice(index, 1);
                users1.forEach(function({ fileName, str }, index) {
                    console.log("[" + index + "]:users1 " + fileName);
                });
                localStorage.setItem("users", JSON.stringify(users1));
                location.reload(true);
                $add();
            }

        });
    });

}