package com.naveen;

@Controller  
public class HelloController {  
   // private static final String UPLOAD_DIRECTORY ="/images";  
      
    @RequestMapping("/uploadform")  
    public ModelAndView uploadForm(){  
        return new ModelAndView("uploadform");    
    }  
      
    @RequestMapping(value="/savefile",method=RequestMethod.POST)  
    public ModelAndView saveimage(@RequestParam CommonsMultipartFile file,  
           HttpSession session) throws Exception{  
  
    ServletContext context = session.getServletContext();  
    String path = context.getRealPath("/");  
    String filename = file.getOriginalFilename();  
  
    System.out.println(path+" "+filename);        
  
    byte[] bytes = file.getBytes();  
    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
         new File(path + File.separator + filename)));  
    stream.write(bytes);  
    stream.flush();  
    stream.close();  
           
    return new ModelAndView("uploadform","filesuccess","File successfully saved!");  
    }  
}  