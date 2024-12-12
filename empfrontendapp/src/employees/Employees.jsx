import axios from 'axios'
import {useEffect,useState} from 'react'

const Employees = () => {

    const [employees,setEmployees] = useState([])

    const getEmployees = async () => {
        const response = await axios.get("http://localhost:9090/allemployees")
        const {data} = response
        setEmployees(data)
    }
    const delete_emp = async (eid) => {
        const isConfirmed = window.confirm('Are you sure you want to delete this employee?');
        if (isConfirmed) {
            try {
                await axios.delete(`http://localhost:9090/employees/${eid}`);
                alert('Employee deleted successfully');
                // Refresh employee list after deletion
                getEmployees();
            } catch (error) {
                console.error('Error deleting employee:', error);
                alert('Failed to delete employee');
            }
        }
    };

    useEffect(()=>{
        getEmployees();
    },[]) // empty dependency

   return (
    <div>
        <table border={1} align='center' cellSpacing={10} cellPadding={10}>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Employee Salary</th>
                    <th>Employee Image</th>
                    <th>Employee Designation</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
             {
               employees.map( (employee,index) => (
                        <tr key={index}>
                            <td>{employee.eid}</td>
                            <td>{employee.ename}</td>
                            <td>{employee.esal}</td>
                            <td><img src={employee.eimage} width={50}/></td>
                            <td>{employee.edesig}</td>
                            <td><i className='fa fa-edit'></i></td>
                            <td><i className='fa fa-trash'
                                    style={{ cursor: 'pointer', color: 'red' }}
                                    onClick={() => delete_emp(employee.eid)}
                                ></i>
                            </td>
                        </tr>
                    
               ) )
             }
            </tbody>
        </table>
    </div>
   )
   
}


export default Employees;