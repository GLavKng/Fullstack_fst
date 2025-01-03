
import React from "react"
const UserList = () => {
  return (
    <div className="container mx-auto my-8 px-10">
        <div className="flex shadow border-b">
            <table className = "min-w-full">
                <thead className="bg-gray-50">
                    <tr>
                        <th className="text-left font-medium text-gray-500 uppercase tracking-wide py-3 px-6">First Name</th>
                        <th className="text-left font-medium text-gray-500 uppercase tracking-wide py-3 px-6">Last Name</th>
                        <th className="text-left font-medium text-gray-500 uppercase tracking-wide py-3 px-6">Email id</th>
                        <th className="text-right font-medium text-gray-500 uppercase tracking-wide py-3 px-6">Actions</th>
                    </tr>
                </thead>
                <tbody className="bg-white">
                    <tr>
                        <td className="text-left px-6 py-4 whitespace-nowrap">
                            <div className="text-sm text-gray-500">Laur</div>
                        </td>
                        <td className="text-left px-6 py-4 whitespace-nowrap">
                            <div className="text-sm text-gray-500">Pinzaru</div>
                        </td>
                        <td className="text-left px-6 py-4 whitespace-nowrap">
                            <div className="text-sm text-gray-500">laur@mail.ru</div>
                        </td>
                        <td className="text-right px-6 py-4 whitespace-nowrap">
                           <a href="#" className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer px-4">Edit</a>
                           <a href="#" className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer">Delete</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
  );
};

export default UserList;