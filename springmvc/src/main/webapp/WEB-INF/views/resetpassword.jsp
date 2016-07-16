<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa fa-bars"></i> Pages</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
                    <li><i class="fa fa-bars"></i>Pages</li>
                    <li><i class="fa fa-square-o"></i>Pages</li>
                </ol>
            </div>
        </div>
        <!-- page start-->
        <!--tab nav start-->
        <section class="panel">
            <header class="panel-heading tab-bg-primary ">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a data-toggle="tab" href="#general">Genaral</a>
                    </li>
                    <li class="">
                        <a data-toggle="tab" href="#prediction">Prediction</a>
                    </li>


                </ul>
            </header>
            <div class="panel-body">
                <div class="tab-content">
                    <div id="home" class="tab-pane active">
                        Genaral
                    </div>
                    <div id="about" class="tab-pane">Prediction</div>

                </div>
            </div>
        </section>
        <!--tab nav start-->
        <section class="panel">
            <div class="left">
                <p><h2> Select Date Range</h2></p>
                <p>To : <input type="text" id="to"></p>
            </div>
            <div class="right">
                <p>From : <input type="text" id="from"></p>
            </div>
        </section>
        <section class="panel">
            <div></div>
            <select class="form-control">
                <option value="">- Choose Device -</option>
                <option value="1">PC</option>
                <option value="2">Mobile Phone</option>
                <option value="3">Lap top</option>
                <option value="4">All</option>
            </select>
        </section>
        <div></div>
        <div></div>

        <section class ="panel">

            <div>
                <a class="btn btn-primary" href="" title="Bootstrap 3 themes generator">Genarate graph</a>
            </div>

            <div></div>
            <div></div>
        </section>

        <section class="panel">
        <div class="col-lg-6">
            <section class="panel">
                <!-- <header class="panel-heading">
                    Bar
                </header>
                <div class="panel-body text-center">
                    <canvas id="bar" height="300" width="500"></canvas>
                </div> -->
                <img src="${pageContext.request.contextPath}/resources/img/electronic-devices-used-1a.png">
            </section>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>






    