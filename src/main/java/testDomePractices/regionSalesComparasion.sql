/*An insurance company maintains records of sales made by its employees. Each employee is assigned to a state.
States are grouped under regions. The following tables contain the data:*/

TABLE regions
id INTEGER PRIMARY KEY
  name VARCHAR(50) NOT NULL

TABLE states
  id INTEGER PRIMARY KEY
  name VARCHAR(50) NOT NULL
  regionId INTEGER NOT NULL
  FOREIGN KEY (regionId) REFERENCES regions(id)

TABLE employees
  id INTEGER PRIMARY KEY
  name VARCHAR(50) NOT NULL
  stateId INTEGER NOT NULL
  FOREIGN KEY (stateId) REFERENCES states(id)

TABLE sales
  id INTEGER PRIMARY KEY
  amount INTEGER NOT NULL
  employeeId INTEGER NOT NULL
  FOREIGN KEY (employeeId) REFERENCES employees(id)

/*
Management requires a comparative region sales analysis report.

Write a query that returns:

-The region name.
-Average sales per employee for the region (Average sales = Total sales made for the region / Number of employees in the region).
-The difference between the average sales of the region with the highest average sales,
and the average sales per employee for the region (average sales to be calculated as explained above).

Employees can have multiple sales. A region with no sales should be also returned.
Use 0 for average sales per employee for such a region when calculating the 2nd and the 3rd column.*/

with SalesAvg as (
    select R.name as rgn,
        CASE WHEN SUM(ifnull (SL.amount, 0)) = 0 then 0
             ELSE SUM(ifnull(SL.amount,0))/ COUNT(DISTINCT E.id) END as average
    from regions R
             left join states S on R.id = S.regionId
             left join employees E on S.id = E.stateId
             left join sales SL on E.id = SL.employeeId
    group by R.Id, R.name
)
select rgn,
       average,
       (select max(average) from SalesAvg) - average as difference
from SalesAvg
group by rgn;