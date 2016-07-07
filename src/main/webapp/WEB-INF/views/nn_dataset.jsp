<%--
  Created by IntelliJ IDEA.
  User: asantha
  Date: 7/6/16
  Time: 5:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="false" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <style>
            .fileinput-button {
                border: 1px solid #e6e6e6 !important;
                background: #4cd964 !important;
            }
        </style>
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa-database"></i> Train Neural Networks</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="#">Home</a></li>
                    <li><i class="fa fa-university"></i> Train Neural Networks</li>
                </ol>
            </div>
        </div>
        <div class="row">

            <div class="col-lg-12">

                <section class="panel">

                    <header class="panel-heading">Construct Neural Network</header>
                    <div class="panel-body">
                        <div class="form">
                            <form id="fileupload" class="form-validate form-horizontal" id="feedback_form" method="post" enctype="multipart/form-data" action="${home}/upload_dataset">

                                <div class="form-group">

                                    <label class="control-label col-lg-2">Type Of Dataset <span class="required">*</span></label>
                                    <div class="col-lg-10">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="dataset_type" class="dataset_type" id="dataset_type1" value="qualified">
                                            Qualified Dataset
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="dataset_type" class="dataset_type" id="dataset_type2" value="unqualified">
                                            UnQualified Dataset
                                        </label>
                                    </div>
                                    </div>
                                </div>
                                <div class="form-group" id="qualified">

                                    <noscript><input type="hidden" name="redirect"
                                                     value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>
                                    <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
                                    <div class="row fileupload-buttonbar">
                                        <div class="col-lg-7">
                                            <!-- The fileinput-button span is used to style the file input field as button -->
                                            <span class="btn btn-success fileinput-button">
                                                <i class="glyphicon glyphicon-plus"></i>
                                                <span>Add files...</span>
                                                <input type="file" name="files" multiple>
                                            </span>
                                            <button type="submit" class="btn btn-primary start">
                                                <i class="glyphicon glyphicon-upload"></i>
                                                <span>Start upload</span>
                                            </button>
                                            <button type="reset" class="btn btn-warning cancel">
                                                <i class="glyphicon glyphicon-ban-circle"></i>
                                                <span>Cancel upload</span>
                                            </button>
                                            <button type="button" class="btn btn-danger delete">
                                                <i class="glyphicon glyphicon-trash"></i>
                                                <span>Delete</span>
                                            </button>
                                            <input type="checkbox" class="toggle">
                                            <!-- The global file processing state -->
                                            <span class="fileupload-process"></span>
                                        </div>
                                        <!-- The global progress state -->
                                        <div class="col-lg-5 fileupload-progress fade">
                                            <!-- The global progress bar -->
                                            <div class="progress progress-striped active" role="progressbar"
                                                 aria-valuemin="0" aria-valuemax="100">
                                                <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                                            </div>
                                            <!-- The extended global progress state -->
                                            <div class="progress-extended">&nbsp;</div>
                                        </div>
                                    </div>
                                    <!-- The table listing the files available for upload/download -->
                                    <table role="presentation" class="table table-striped">
                                        <tbody class="files"></tbody>
                                    </table>
                                </div>
                                <div class="form-group" id="unqualified">

                                    <noscript><input type="hidden" name="redirect"
                                                     value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>
                                    <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
                                    <div class="row fileupload-buttonbar">
                                        <div class="col-lg-7">
                                            <!-- The fileinput-button span is used to style the file input field as button -->
                                            <span class="btn btn-success fileinput-button">
                                                <i class="glyphicon glyphicon-plus"></i>
                                                <span>Add files...</span>
                                                <input type="file" name="files" multiple>
                                            </span>
                                            <button type="submit" class="btn btn-primary start">
                                                <i class="glyphicon glyphicon-upload"></i>
                                                <span>Start upload</span>
                                            </button>
                                            <button type="reset" class="btn btn-warning cancel">
                                                <i class="glyphicon glyphicon-ban-circle"></i>
                                                <span>Cancel upload</span>
                                            </button>
                                            <button type="button" class="btn btn-danger delete">
                                                <i class="glyphicon glyphicon-trash"></i>
                                                <span>Delete</span>
                                            </button>
                                            <input type="checkbox" class="toggle">
                                            <!-- The global file processing state -->
                                            <span class="fileupload-process"></span>
                                        </div>
                                        <!-- The global progress state -->
                                        <div class="col-lg-5 fileupload-progress fade">
                                            <!-- The global progress bar -->
                                            <div class="progress progress-striped active" role="progressbar"
                                                 aria-valuemin="0" aria-valuemax="100">
                                                <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                                            </div>
                                            <!-- The extended global progress state -->
                                            <div class="progress-extended">&nbsp;</div>
                                        </div>
                                    </div>
                                    <!-- The table listing the files available for upload/download -->
                                    <table role="presentation" class="table table-striped">
                                        <tbody class="files"></tbody>
                                    </table>
                                </div>
                                <div class="form-group">

                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-primary" type="submit">Train Model</button>
                                        <button class="btn btn-default" type="button">Cancel</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <script>
            $(document).ready(function () {

                var dataset="";
                $('#unqualified').slideUp();
                $('#qualified').slideUp();
                $('input:radio[name="dataset_type"]').change(function(){

                    dataset = $(this).val();
                    if(dataset==="qualified") {

                        $('#qualified').slideDown();
                        $('#unqualified').slideUp();
                    }else{

                        $('#qualified').slideUp();
                        $('#unqualified').slideDown();
                    }
                });
                $('#qualified_datasetupload').dropzone({

                    url: "${home}/file_upload_qualify",
                    dictDefaultMessage: "Drop a dataset files here(CSV,txt,xml)"
                });
                $('#unqualified_datasetupload').dropzone({

                    url: "${home}/file_upload_disqualify",
                    dictDefaultMessage: "Drop a dataset files here(CSV,txt,xml)"
                });
            })

            $(function () {

                $('#fileupload').fileupload({
                    // Uncomment the following to send cross-domain cookies:
                    //xhrFields: {withCredentials: true},
                    url: '${home}/upload_dataset'
                });

                // Enable iframe cross-domain access via redirect option:
                $('#fileupload').fileupload(
                        'option',
                        'redirect',
                        window.location.href.replace(
                                /\/[^\/]*$/,
                                '/cors/result.html?%s'
                        )
                );

                $('#fileupload').addClass('fileupload-processing');
                $.ajax({
                    // Uncomment the following to send cross-domain cookies:
                    //xhrFields: {withCredentials: true},
                    url: $('#fileupload').fileupload('option', 'url'),
                    dataType: 'json',
                    context: $('#fileupload')[0]
                }).always(function () {
                    $(this).removeClass('fileupload-processing');
                }).done(function (result) {
                    $(this).fileupload('option', 'done')
                            .call(this, $.Event('done'), {result: result});
                });
            })
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>
