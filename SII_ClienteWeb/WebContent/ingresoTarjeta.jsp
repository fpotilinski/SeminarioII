<%@ page import="dto.ArticuloDTO"%>
<%@ page import="dto.VendedorDTO"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">

  <head>
	<script src="https://secure.mlstatic.com/sdk/javascript/v1/mercadopago.js"></script>
	<script> Mercadopago.setPublishableKey("TEST-e4f0eaea-fa65-4402-aec9-3b3b5f831453"); </script>
    <script>document.getElementById("docType").innerHTML = Mercadopago.getIdentificationTypes();</script>
    
    <script language="javascript" type="text/javascript">
    function addEvent(el, eventName, handler){
        if (el.addEventListener) {
               el.addEventListener(eventName, handler);
        } else {
            el.attachEvent('on' + eventName, function(){
              handler.call(el);
            });
        }
    };

    function getBin() {
        var ccNumber = document.querySelector('input[data-checkout="cardNumber"]');
        return ccNumber.value.replace(/[ .-]/g, '').slice(0, 6);
    };

    function guessingPaymentMethod(event) {
        var bin = getBin();
        Mercadopago.setPublishableKey("TEST-e4f0eaea-fa65-4402-aec9-3b3b5f831453");
        if (event.type == "keyup") {
        	
            if (bin.length >= 6) {
                Mercadopago.getPaymentMethod({
                    "bin": bin
                }, setPaymentMethodInfo);
            }
        } else {
            setTimeout(function() {
                if (bin.length >= 6) {
                    Mercadopago.getPaymentMethod({
                        "bin": bin
                    }, setPaymentMethodInfo);
                }
            }, 100);
        }
    };

    function setPaymentMethodInfo(status, response) {
        if (status == 200) {
            // do somethings ex: show logo of the payment method
            var form = document.querySelector('#pay');

            if (document.querySelector("input[name=paymentMethodId]") == null) {
                var paymentMethod = document.createElement('input');
                paymentMethod.setAttribute('name', "paymentMethodId");
                paymentMethod.setAttribute('type', "hidden");
                paymentMethod.setAttribute('value', response[0].id);
                form.appendChild(paymentMethod);
            } else {
                document.querySelector("input[name=paymentMethodId]").value = response[0].id;
            }
        }

    };
    
    
    
    
    
    function sdkResponseHandler(status, response) {
        if (status != 200 && status != 201) {
            alert("verify filled data");
        }else{
           
            var form = document.querySelector('#pay');

            var card = document.createElement('input');
            card.setAttribute('name',"token");
            card.setAttribute('type',"hidden");
            card.setAttribute('value',response.id);
            form.appendChild(card);
            doSubmit=true;
            form.submit();
        }
    };
    
    </script>
    
   <script language="javascript" type="text/javascript">addEvent(document.querySelector('input[data-checkout="cardNumber"]'), 'keyup', guessingPaymentMethod);</script>
    <script language="javascript" type="text/javascript">addEvent(document.querySelector('input[data-checkout="cardNumber"]'), 'change', guessingPaymentMethod);</script>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>iaPOS!</title>

    <!-- Bootstrap core CSS -->
    <link href="http://localhost:8180/APD_CTE_WEB/vendor2/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://localhost:8180/APD_CTE_WEB/css/3-col-portfolio.css" rel="stylesheet">

  </head>

  <body>



<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container-fluid">
      
        <a class="navbar-brand" href="#"><img src="http://localhost:8180/APD_CTE_WEB/logochico.png" 
     srcset = "http://localhost:8180/APD_CTE_WEB/logochico.png 2x, 
             http://localhost:8180/APD_CTE_WEB/logochico.png 768w, 
             http://localhost:8180/APD_CTE_WEB/logochico.png 768w 2x, 
             http://localhost:8180/APD_CTE_WEB/logochico.png 1200w, 
             http://localhost:8180/APD_CTE_WEB/logochico.png 1200w 2x" /></a>
        <h1 class="my-41">
         <% VendedorDTO vendedor= (VendedorDTO)session.getAttribute("vendedor");%>
         <% List<ArticuloDTO> carrito= (List<ArticuloDTO>)session.getAttribute("carrito");%>
         <% int cantidad = carrito.size();%>
        <verysmall>Bienvenido, <%=vendedor.getNombre() %></verysmall>
      </h1>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="ServletModuloVentas?action=verCarrito">Ver carrito (<%=cantidad%>)
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ServletModuloVentas?action=cerrarSesion">Cerrar sesión</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container" >
      <!-- Page Heading -->
      <h1 class="my-4">iaPOS
        <small>Pago | Ingreso de Tarjeta</small>
      </h1>
      
            <form onSubmit="procesarMP()" action="/APD_CTE_WEB/servlets/ServletModuloVentas" method="post" id="pay" name="pay" >
            <fieldset>
            <table class="table table-bordered" cellspacing="0" witdh=50%>
            
            <tr>
            <td>
            Número de Tarjeta:
            </td>
            <td>
            <input data-checkout="cardNumber" class="form-control" type="text" id="cardNumber"  onselectstart="return false" onpaste="return false" onCopy="return false" onCut="return false" onDrag="return false" onDrop="return false" autocomplete=off />
            </td>
            </tr>
            <tr>
            <td>
            Código de Seguridad:
            </td>
            <td>
            <input class="form-control"  type="text" id="securityCode" data-checkout="securityCode" placeholder="123" onselectstart="return false" onpaste="return false" onCopy="return false" onCut="return false" onDrag="return false" onDrop="return false" autocomplete=off />
            </td>
            </tr>
            <tr>
            <td>
            Mes de Vencimiento:
            </td>
            <td>
            <input class="form-control"  type="text" id="cardExpirationMonth" data-checkout="cardExpirationMonth" placeholder="12" onselectstart="return false" onpaste="return false" onCopy="return false" onCut="return false" onDrag="return false" onDrop="return false" autocomplete=off />
            </td>
            </tr>
            <tr>
            <td>
            Año de Vencimiento:
            </td>
            <td>
            <input class="form-control"  type="text" id="cardExpirationYear" data-checkout="cardExpirationYear" placeholder="2015" onselectstart="return false" onpaste="return false" onCopy="return false" onCut="return false" onDrag="return false" onDrop="return false" autocomplete=off />
            </td>
            </tr>
            <tr>
            <td>
            Titular de la Tarjeta:
            </td>
            <td>
            <input class="form-control"  type="text" id="cardholderName" data-checkout="cardholderName" />
            </td>
            </tr>
            <tr>
            <p id="demo"></p>
            <td>
            Tipo Documento:
            </td>
            <td>
            <select class="form-control"  id="docType" data-checkout="docType"></select>
            </td>
            </tr>
            <tr>
            <td>
            Nro Documento:
            </td>
            <td>
            <input class="form-control"  type="text" id="docNumber" data-checkout="docNumber" placeholder="12345678" />
            </td>
            </tr>
            </table>
            
             <table class="table table-bordered" cellspacing="0" witdh=50%>
            <tr>
            <td>
            <input type="hidden" name="paymentMethod" />
            <input type="hidden" name="card" />
        	<input type="hidden" name="action" value="test">
    
            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#exampleModal">Cambiar medio de pago</a>

            <input type="submit" class="btn btn-primary" align=center name="procesarAltaCliente" value="Confirmar">
            </td>
            </tr> 
            </fieldset>
            </table>
            
            
            </form>
  <button onclick="guessingPaymentMethod()">Click me</button>
      <!-- /.row -->

      <!-- Pagination -->


    </div>
    <!-- /.container -->
    
      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Confirmación de compra</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Seleccione el medio de pago</div>

          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="ServletModuloVentas?action=ingresoMedioPago&medioPago=efectivo">Efectivo</a>
            <a class="btn btn-primary" href="ServletModuloVentas?action=ingresoMedioPago&medioPago=cheque">Cheque</a>
            <a class="btn btn-primary" href="ServletModuloVentas?action=ingresoMedioPago&medioPago=tarjeta">Tarjeta</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white"></p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="http://localhost:8180/APD_CTE_WEB/vendor/jquery/jquery.min.js"></script>
    <script src="http://localhost:8180/APD_CTE_WEB/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
