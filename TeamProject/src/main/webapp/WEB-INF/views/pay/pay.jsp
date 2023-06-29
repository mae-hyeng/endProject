<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
  <title>Toss Widget Example</title>
</head>
<body>
  <button onclick="openTossWidget()">Open Toss Widget</button>

  <script src="https://widget.tosspayments.com/v1"></script>
  <script>
    function openTossWidget() {
      TossPayments.init('test_sk_N5OWRapdA8dDDXEYzNn8o1zEqZKL');
      TossPayments.startPayment({
        amount: 1000,
        orderId: 'ORDER_ID',
        callbackUrl: 'http://your-callback-url.com',
        // 필요한 추가 파라미터 및 옵션을 지정할 수 있습니다.
      });
    }
  </script>
</body>
</html>