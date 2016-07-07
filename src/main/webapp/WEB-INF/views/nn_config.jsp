<%--
  Created by IntelliJ IDEA.
  User: asantha
  Date: 7/6/16
  Time: 5:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="false" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa-university"></i> Neural Networks Config</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="#">Home</a></li>
                    <li><i class="fa fa-laptop"></i>Neural Networks Config</li>
                </ol>
            </div>
        </div>
        <div class="row">

            <div class="col-lg-12">

                <section class="panel">

                    <header class="panel-heading">Construct Neural Network</header>
                    <div class="panel-body">
                        <div class="form">
                            <form class="form-validate form-horizontal" id="feedback_form" method="get" action="#">

                                <div class="form-group ">
                                    <label for="cname" class="control-label col-lg-2">Full Qualified Package Name <span class="required">*</span></label>
                                    <div class="col-lg-10">
                                        <input class="form-control" id="cname" name="packagename" minlength="5" type="text" required />
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="ccolumns" class="control-label col-lg-2">Number Of Input Columns <span class="required">*</span></label>
                                    <div class="col-lg-10">
                                        <input class="form-control" id="ccolumns" name="columns" minlength="5" type="text" required />
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="coutputs" class="control-label col-lg-2">Number Of Outputs <span class="required">*</span></label>
                                    <div class="col-lg-10">
                                        <input class="form-control" id="coutputs" name="outputs" minlength="5" type="text" required />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-primary" type="submit">Generate Model</button>
                                        <button class="btn btn-default" type="button">Cancel</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
