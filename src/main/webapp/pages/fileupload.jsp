<%-- 
    Document   : fileupload
    Created on : 2017/4/17, 上午 08:51:56
    Author     : Wei.Cheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<script>
    $(function () {
        var form = $("#uploadForm");
        var submitUrl = "${root}WorktimeBatchMod/";

        $("#sync-img").hide();
        var options = {
            beforeSubmit: function (arr, $form, options) {
                if (!confirm("資料確認無誤? " + $("#action").val() + " ?")) {
                    return false;
                }
            },
            beforeSend: function () {
                $("#progressbox").show();
                // clear everything
                $("#progressbar").width('0%');
                $("#message").empty();
                $("#percent").html("0%");
            },
            uploadProgress: function (event, position, total, percentComplete) {
                $("#progressbar").width(percentComplete + '%');
                $("#percent").html(percentComplete + '%');

                // change message text to red after 50%
                if (percentComplete > 50) {
                    $("#sync-img").show();
                    $("#message").html("<font color='red'>File Upload is in progress</font><p>Data synchronizing...</p>");
                }
            },
            success: function (response) {
                $("#progressbar").width('100%');
                $("#percent").html('100%');
                $("#message").html("<font color='blue'>" + response + "</font>");
            },
            complete: function (response) {
                $("#message").html(response.responseText);
                $("#sync-img").hide();
            },
            error: function () {
                $("#message").html("<font color='red'> ERROR: unable to upload files</font>");
                $("#sync-img").hide();
            }
        };
        form.ajaxForm(options);

        form.attr("action", submitUrl + $("#action").val());

        $("#action").on("change", function () {
            form.attr("action", submitUrl + $(this).val());
        });

    });
</script>
<div>
    <h3>Upload single files example.</h3>
    <form id="uploadForm" method="post" enctype="multipart/form-data">
        <div class="form-inline">
            <lable for="action">請選擇操作項目</lable>
            <select id="action" name="action" class="form-control">
                <option value="add">Add</option>
                <option value="update">Update</option>
                <option value="delete">Delete</option>
            </select>
        </div>
        <div class="form-inline">
            <lable for="file">File to upload: </lable>
            <input type="file" name="file" class="form-control">
        </div>
        <div class="form-inline">
            <input type="submit" value="Upload" class="form-control"> 
            <label>Press here to upload the file!</label>
        </div>
        <div id="progressbox">
            <div id="progressbar"></div>
            <div id="percent">0%</div>
            <img id="sync-img" src="../images/hex-loader2.gif" />
        </div>
        <div id="message"></div>
    </form>	
</div>
<hr />
<div>
    <c:forEach items="${message}" var="element">    
        <c:out value="${element}"/>
        <br />
    </c:forEach>
</div>

