console.log("AJSFKLASDJF");

$(document).ready(function() {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/newaddressbook"
    }).then(function(data) {
        $('.addressbook-id').append(data.id);
    });
});