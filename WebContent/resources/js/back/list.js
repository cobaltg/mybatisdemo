/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatchServlet.action");
	$("#mainForm").submit();
}

function changCurrentPage(currentPage){
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}
