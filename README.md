# LogAnalysis
Commit LogsUtil

FUNCTION TO CREATE DIRECTORY AND FILES IN IT ..
---------------------------------------------------
 /**
     *
     *  getPublicAlbumStorageDir function
     *  will create and write the file in the directory you want ..
     */

    public File getPublicAlbumStorageDir(String dirName,String filename_ext,StringBuilder content) {

        /*
         * THE Environment.getExternalStorageDirectory() GET DIR(PIC/IMAGES..ETC)
         */
        File file_dir = new File(Environment.getExternalStorageDirectory(), dirName);
        if (!file_dir.mkdirs()) {
            Log.e("LOG_TAG", "Directory not created");
        }

        /*
         * Creates a File the Directory you want
         * THIS CREATES THE COMPLETE FILE PATH
         */
        File filepath = new File(file_dir,filename_ext);

        try{
            FileWriter fileWriter = new FileWriter(filepath);
            fileWriter.write(content.toString());
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }




        return file_dir;
    }
    
  FUNCTION TO GET THE LOGS:
  ---------------------------
    
    public static StringBuilder readLogs() {
        StringBuilder logBuilder = new StringBuilder();
        try {




           // Process TO READ THE LOGCAT LOGS..
           Process process = Runtime.getRuntime().exec(new String[]{"logcat", "-d"});
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                logBuilder.append(line + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logBuilder;
    }
    
