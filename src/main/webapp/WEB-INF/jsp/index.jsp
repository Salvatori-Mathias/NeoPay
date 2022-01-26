<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

      <!doctype html>
      <html lang="en">

      <head>
        <title>index</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/pricing/">
           <!-- Bootstrap core CSS -->
                <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
         <link href="index.css" rel="stylesheet">

      </head>

      <body>

<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
          <symbol id="check" viewBox="0 0 16 16">
            <title>Check</title>
            <path
              d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
          </symbol>
        </svg>

        <div class="container py-3">
          <header class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
            <div>
                    <img src="neo3.png" width="150px">
            </div>
            <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
              <a class="me-3 py-2 text-dark text-decoration-none" href="/paymybuddy">Home</a>
              <a class="me-3 py-2 text-dark text-decoration-none" href="/paymybuddy/profile">Profile</a>
              <a class="me-3 py-2 text-dark text-decoration-none" href="/paymybuddy/contact">Contact</a>
              <a class="py-2 text-dark text-decoration-none" href="/paymybuddy/logout">Log off </a>
            </nav>
          </header>
          <div class="box">

            <div class="selected"><a href="connection"><button class="btn btn-lg btn-primary btn-block">add a connection</button></a></div>

          </div>


          <div class="flex">

            </br>
            <h4> Send money
            </h4>




              <main>
                </br>
                <h2 class="display-6 text-left mb-4">My transactions</h2>

                <div class="table-responsive">
                  <table class="table text-center">
                    <thead>
                      <tr >
                        <th>Connection</th>
                        <th>Connection name</th>
                        <th>Amount</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${transfers}" var="transfer">
                                              <tr>
                                              <td>${transfer.to.email} </td>
                                              <td> ${transfer.to.firstName} ${transfer.to.lastName}</td>
                                              <td> ${transfer.amountBeforeFee} €</td>
                                              </tr>
                                               </c:forEach>
                    </tbody>
                  </table>
                </div>
              </main>

              <footer class="pt-4 my-md-5 pt-md-5 border-top">

              </footer>
            </div>
          </div>
        </div>

      </body>


      </html>