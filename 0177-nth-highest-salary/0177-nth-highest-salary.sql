CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N-1;
    RETURN (
        # Write your MySQL query statement below.
        SELECT DISTINCT salary
        FROM Employee
        ORDER BY salary DESC
        LIMIT N, 1
    );
END

# When you write LIMIT N-1, 1 directly in the RETURN statement, MySQL does not evaluate N-1 as an expression in the context of the LIMIT clause.Instead, it expects a constant integer value or a variable that has been defined and assigned a value.

