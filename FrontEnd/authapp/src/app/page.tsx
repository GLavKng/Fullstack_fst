
import Head from "next/head";
import Navbar from "./components/Navbar";
import UserList from "./components/UserList";
export default function Home() {
  return (
   <div>
    <Head>
      <title>User Managment app</title>
    </Head> 
     <Navbar />
    
    <main>
      <UserList />
      </main>
    </div>
  );
}
