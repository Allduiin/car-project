1.
SELECT city, MAX(grade)
FROM CUSTOMERS
GROUP BY city;

2.1
SELECT customer_id, ord_date, purch_amt
 FROM orders
ORDER BY customer_id, ord_date;
2.2
SELECT customer_id, ord_date, MAX(purch_amt)
 FROM orders
GROUP BY customer_id, ord_date
HAVING MAX(purch_amt) BETWEEN 2000 AND 6000;

3.1
SELECT customer_id, cust_name, city, grade, salesman_id
FROM customer c
INNER JOIN salesman s ON c.salesman_id = s.salesman_id
WHERE s.commision > 0.12;
3.2
SELECT * FROM customer c
LEFT JOIN salesman s ON c.salesman_id = s.salesman_id
ORDER BY c.customer_id;
3.3
SELECT * FROM customer c
LEFT JOIN salesman s ON c.salesman_id = s.salesman_id
WHERE grade < 300
ORDER BY c.customer_id;

4
SELECT DPT_NAME
FROM emp_department dep
INNER JOIN emp_details e_det ON dep.DPT_CODE = e_det.EMP_DEPT
GROUP BY DPT_NAME;
HAVING COUNT(*) > 2;
