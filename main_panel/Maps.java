package main_panel;
public class Maps { 
    static final int [][][] floors() {
        return FLOORS.clone();
    }
    private static final int[][][] FLOORS = new int[][][] {
     {
     {0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,1  ,0  ,0  ,0  ,0  ,0  ,0  },
     {3  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,6  ,71 ,5  ,1  ,1  ,1  ,1  ,4  },
     {2  ,104,15 ,15 ,15 ,15 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {13 ,1  ,1  ,1  ,1  ,1  ,8  ,0  ,0  ,0  ,0  ,0  ,3  ,1  ,1  ,1  ,14 ,1  ,1  ,1  ,14 ,1  ,1  ,1  ,11 },
     {2  ,0  ,0  ,0  ,0  ,0  ,91 ,0  ,0  ,0  ,0  ,0  ,2  ,17 ,17 ,17 ,2  ,0  ,72 ,0  ,2  ,0  ,72 ,0  ,2  },
     {2  ,73 ,0  ,18 ,0  ,76 ,7  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,53 ,0  ,2  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,2  },
     {2  ,74 ,0  ,19 ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,5  ,8  ,88 ,10 ,12 ,8  ,88 ,10 ,11 },
     {2  ,75 ,0  ,20 ,0  ,76 ,2  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  }, 
     {13 ,1  ,1  ,1  ,1  ,1  ,6  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,3  ,1  ,1  ,4  ,0  ,0  ,3  ,1  ,1  ,11 },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,72 ,0  ,2  ,0  ,0  ,2  ,0  ,72 ,2  },
     {2  ,0  ,0  ,0  ,7  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,9  ,0  ,0  ,2  ,0  ,0  ,9  ,0  ,0  ,9  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,91 ,0  ,0  ,2  ,0  ,0  ,89 ,0  ,0  ,89 ,0  ,0  ,2  },
     {2  ,0  ,0  ,51 ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,3  ,1  ,1  ,12 ,14 ,1  ,1  ,1  ,14 ,1  ,1  ,1  ,11 },
     {2  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,17 ,17 ,17 ,2  ,0  ,72 ,0  ,2  ,0  ,72 ,0  ,2  },
     {2  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,52 ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,5  ,8  ,88 ,10 ,12 ,8  ,88 ,10 ,11 },
     {2  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,9  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,91 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {13 ,1  ,1  ,1  ,6  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,7  ,0  ,0  ,0  ,3  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,11 },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,9  ,0  ,16 ,0  ,16 ,0  ,16 ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {5  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,12 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,6  }
     },
     {
     {0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,1  ,1  ,1  ,1  ,1  ,0  ,0  ,0  ,0  ,0  },
     {3  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,70 ,1  ,71 ,1  ,1  ,1  ,1  ,1  ,4  },
     {2  ,0  ,0  ,0  ,0  ,0  ,82 ,29 ,83 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,58 ,30 ,59 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {13 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,8  ,0  ,0  ,0  ,0  ,0  ,10 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,11 },
     {2  ,15 ,15 ,15 ,15 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,2  },
     {13 ,1  ,1  ,4  ,0  ,0  ,0  ,21 ,24 ,22 ,24 ,22 ,24 ,23 ,0  ,0  ,21 ,24 ,22 ,24 ,22 ,24 ,23 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,25 ,28 ,26 ,28 ,26 ,28 ,27 ,0  ,0  ,25 ,28 ,26 ,28 ,26 ,28 ,27 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,54 ,2  ,100,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,21 ,24 ,22 ,24 ,22 ,24 ,23 ,0  ,0  ,21 ,24 ,22 ,24 ,22 ,24 ,23 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,25 ,28 ,26 ,28 ,26 ,28 ,27 ,0  ,0  ,25 ,28 ,26 ,28 ,26 ,28 ,27 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,2  },
     {2  ,0  ,55 ,2  ,109,0  ,0  ,21 ,24 ,22 ,24 ,22 ,24 ,23 ,0  ,0  ,21 ,24 ,22 ,24 ,22 ,24 ,23 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,25 ,28 ,26 ,28 ,26 ,28 ,27 ,0  ,0  ,25 ,28 ,26 ,28 ,26 ,28 ,27 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,81 ,0  ,2  },
     {2  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {5  ,1  ,1  ,12 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,6  }
     },
     {
     {0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,1  ,1  ,1  ,1  ,1  ,0  ,0  ,0  ,0  ,0  },
     {3  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,70 ,1  ,71 ,1  ,1  ,1  ,1  ,1  ,4  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,56 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,90 ,10 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,4  ,90 ,10 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,11 },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,84 ,0  ,84 ,0  ,84 ,0  ,84 ,0  ,2  ,0  ,0  ,0  ,84 ,0  ,84 ,0  ,84 ,0  ,62 ,0  ,2  },
     {2  ,0  ,0  ,36 ,37 ,36 ,37 ,36 ,37 ,36 ,37 ,0  ,2  ,0  ,0  ,36 ,37 ,36 ,37 ,36 ,37 ,36 ,37 ,0  ,2  },
     {2  ,0  ,0  ,34 ,35 ,34 ,35 ,34 ,35 ,34 ,35 ,0  ,2  ,0  ,0  ,34 ,35 ,34 ,35 ,34 ,35 ,34 ,35 ,0  ,2  },
     {2  ,0  ,0  ,60 ,0  ,85 ,0  ,85 ,0  ,68 ,0  ,0  ,2  ,0  ,0  ,85 ,0  ,85 ,0  ,85 ,0  ,85 ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,86 ,38 ,40 ,0  ,0  ,86 ,38 ,40 ,0  ,0  ,2  ,0  ,86 ,38 ,40 ,0  ,0  ,86 ,38 ,40 ,0  ,0  ,2  },
     {2  ,0  ,0  ,39 ,41 ,87 ,0  ,0  ,39 ,41 ,61 ,0  ,2  ,0  ,0  ,39 ,41 ,87 ,0  ,0  ,39 ,41 ,63 ,0  ,2  },
     {2  ,0  ,86 ,38 ,40 ,0  ,0  ,86 ,38 ,40 ,0  ,0  ,2  ,0  ,67 ,38 ,40 ,0  ,0  ,86 ,38 ,40 ,0  ,0  ,2  },
     {2  ,0  ,0  ,39 ,41 ,65 ,0  ,0  ,39 ,41 ,87 ,0  ,2  ,0  ,0  ,39 ,41 ,87 ,0  ,0  ,39 ,41 ,87 ,0  ,2  },
     {2  ,0  ,64 ,38 ,40 ,0  ,0  ,86 ,38 ,40 ,0  ,0  ,2  ,0  ,86 ,38 ,40 ,0  ,0  ,86 ,38 ,40 ,0  ,0  ,2  },
     {2  ,0  ,0  ,39 ,41 ,87 ,0  ,0  ,39 ,41 ,87 ,0  ,2  ,0  ,0  ,39 ,41 ,87 ,0  ,0  ,39 ,41 ,87 ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,31 ,32 ,33 ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,31 ,32 ,33 ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,69 ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,85 ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {5  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,12 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,6  }
     },
     {
     {0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,1  ,1  ,1  ,0  ,0  ,0  ,0  ,0  ,0  ,0  },
     {3  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,70 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,4  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {13 ,1  ,1  ,1  ,1  ,1  ,8  ,92 ,10 ,1  ,1  ,1  ,4  ,0  ,0  ,10 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,11 },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,91 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,77 ,0  ,18 ,0  ,80 ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,7  ,0  ,0  ,0  ,0  ,0  ,0  ,50 ,0  ,2  },
     {2  ,78 ,0  ,19 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,50 ,0  ,2  },
     {2  ,79 ,0  ,20 ,0  ,80 ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,74 ,50 ,0  ,74 ,50 ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,74 ,50 ,0  ,74 ,50 ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,57 ,0  ,0  ,2  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,42 ,43 ,44 ,45 ,46 ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,74 ,50 ,0  ,74 ,50 ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,47 ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,74 ,50 ,0  ,74 ,50 ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,5  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,11 },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,91 ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  }, 
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,7  ,0  ,0  ,0  ,0  ,0  ,0  ,50 ,0  ,2  },
     {13 ,1  ,1  ,1  ,1  ,1  ,93 ,1  ,1  ,1  ,1  ,1  ,11 ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,50 ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,74 ,50 ,0  ,74 ,50 ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,74 ,50 ,0  ,74 ,50 ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,74 ,50 ,0  ,74 ,50 ,0  ,0  ,0  ,2  },
     {2  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,2  ,0  ,0  ,2  ,74 ,50 ,0  ,74 ,50 ,0  ,0  ,0  ,2  },
     {5  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,12 ,1  ,1  ,12 ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,1  ,6  }
     },
     };
}