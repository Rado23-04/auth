import './App.css'
import Signin from './components/Signin'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Hello from './components/Hello';
import NewUser from './components/NewUser';

function App() {

  return (
    <>
      <Router>
            <Routes>
                <Route path="/" element={<Signin />} />
                <Route path="/hello" element={<Hello />} />
                <Route path='/save' element = {<NewUser/>}/>
            </Routes>
        </Router>

    </>
  )
}

export default App
