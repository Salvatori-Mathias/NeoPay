<!doctype html>
<html lang="en">

<head>
  <%@ page pageEncoding="UTF-8" %>
    <title>contact</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/pricing/">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="index.css" rel="stylesheet">
</head>

<body>


            <title>Check</title>


        <img src="neo3.png" width="150px">


  <div class="container py-3">
    <header class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
    <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
        <a class="me-3 py-2 text-dark text-decoration-none" href="/neopay">Home</a>
        <a class="me-3 py-2 text-dark text-decoration-none" href="/neopay/profile">Profile</a>
        <a class="me-3 py-2 text-dark text-decoration-none" href="/neopay/contact">Contact</a>
        <a class="me-3 py-2 text-dark text-decoration-none" href="/neopay/pay">pay</a>
        <a class="py-2 text-dark text-decoration-none" href="/neopay/logout">Log off </a>
      </nav>
    </header>
    <main>
      <section>
        <div>
          <div class="row">
            <div class="col-sm-12">
              <div class="row">
                <div class="col-sm-8 col-sm-offset-2">
                  <div>
                    <h2>CONTACT US</h2>
                  </div>
                  <form method="post" data-form-title="CONTACT US">
                    <input type="hidden" data-form-email="true">
                    <div class="form-group">
                      <input type="text" class="form-control" name="name" required="" placeholder="Name*"
                        data-form-field="Name">
                    </div>
                    <div class="form-group">
                      <input type="email" class="form-control" name="email" required="" placeholder="Email*"
                        data-form-field="Email">
                    </div>
                    <div class="form-group">
                      <input type="tel" class="form-control" name="phone" placeholder="Phone" data-form-field="Phone">
                    </div>
                    <div class="form-group">
                      <textarea class="form-control" name="message" placeholder="Message" rows="7"
                        data-form-field="Message"></textarea>
                    </div>
                    <div>
                      <button type="submit" class="contact-us">CONTACT US</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

    </main>



</body>

</html>