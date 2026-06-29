import { Routes, Route, Link } from 'react';
import { useNavigate } from 'react-router-dom';

import News15 from './quiz/quiz0615/News15';
import PostRegister from './playground/PostRegister';

// import "bootstrap/dist/css/bootstrap.min.css"

function App() {
  return (
    <div>
      {/* <News15 /> */}
      <PostRegister />
    </div>
  );
}

export default App;