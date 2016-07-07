<%--
  Created by IntelliJ IDEA.
  User: asantha
  Date: 7/6/16
  Time: 4:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page session="false" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa-university"></i> Neural Networks</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="#">Home</a></li>
                    <li><i class="fa fa-laptop"></i>Neural Networks</li>
                </ol>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <section class="panel">
                    <header class="panel-heading">
                        Available Neural Network Models
                        <div class="pull-right"><a class="btn btn-primary"><i class="fa fa-plus"></i> Add New Model</a></div>
                    </header>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th><i class="fa fa-bolt"></i> Neural Network Name</th>
                                <th><i class="fa fa-calendar"></i> Created Date</th>
                                <th><i class="fa fa-database"></i> Last Train Dataset</th>
                                <th><i class="fa fa-times"></i> Last Trained Date</th>
                                <th><i class="fa fa-chain"></i></i> Modifications</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>org.neuralnetwork.FraudDetectorNeuralNet</td>
                                <td>Table cell</td>
                                <td>Table cell</td>
                                <td>Table cell</td>
                                <td>Table cell</td>
                                <td>
                                    <div class="btn-group">
                                        <a class="btn btn-primary" href="${home}/add_dataset" title="Modify"><i class="icon_plus_alt2"></i></a>
                                        <a class="btn btn-danger" href="#" onclick="delete_network($(this))"><i class="icon_close"></i></a>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </section>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
