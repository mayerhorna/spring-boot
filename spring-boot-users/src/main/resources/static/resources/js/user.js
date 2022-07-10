var CONTEXT_PATH = "/";
$(document).ready(function () {
    $('button[name=eliminarButton]').on('click', function (e) {
    	var id = $(this).closest('tr').data('id');
    	$("#userDeleteModal").data("rowid",id);
        $("#userDeleteModal").modal();
        $('#userDeleteModalSiButton').one('click', function (e) {
        	var rowId = $("#userDeleteModal").data("rowid");
        	document.location = CONTEXT_PATH + 'users/delete/'+rowId ;
        });
    });
});