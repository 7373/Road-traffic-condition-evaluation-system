
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
class Inf implements java.io.Serializable{
    String number,name,specialty,grade,borth,sex;
    public Inf(){};
    public void setNumber(String number){ this.number=number;}
    public String getNumber(){ return number;}
    public void setName(String name){ this.name=name;}
    public String getName(){ return name;}
    public void setSex(String sex){ this.sex=sex;}
    public String getSex(){ return sex;}
    public void setSpecialty(String specialty){ this.specialty=specialty;}
    public String getSpecialty(){ return specialty;}
    public void setGrade(String grade){ this.grade=grade;}
    public String getGrade(){ return grade;}
    public void setBorth(String borth){ this.borth=borth;}
    public String getBorth(){ return borth;}
}
public class ex22 extends JFrame{
    JLabel lb=new JLabel("¼������ѡ��·�Σ���ѯ��ɾ������ѡ��·�Σ��޸��ǶԲ�ѯ" +
            "���ݸĺ�ı��棡");
    JTextField ѧ��,����,רҵ,�꼶,����;	
    JComboBox ·��;
    JRadioButton ��æ,����,����;
    ButtonGroup group=null;
    JButton ¼��,��ѯ,ɾ��,�޸�,��ʾ;
    JPanel p0,p1,p2,p3,p4,p5,p6,pv,ph,p7;
    Inf ѧ��=null;
    Hashtable ѧ��ɢ�б�=null;
    File file=null;
    FileInputStream inOne=null;
    ObjectInputStream inTwo=null;
    FileOutputStream outOne=null;
    ObjectOutputStream outTwo=null;
    public ex22(){
      super("��·��ͨ״̬����ϵͳ");
      ѧ��=new JTextField(10);
      ����=new JTextField(3);
      רҵ=new JTextField(3);
      �꼶=new JTextField(3);
      ����=new JTextField(3);
      ·��=new JComboBox();
      group=new ButtonGroup();
      ·��.addItem("һ����");
      ·��.addItem("������");
      ·��.addItem("������");
      ·��.addItem("�ĺ���");
      ·��.setSelectedIndex(3);
      p0=new JPanel();
      p0.add(new JLabel("·��:",JLabel.CENTER));
      p0.add(·��);
      ��æ=new JRadioButton("��æ",true);
      ����=new JRadioButton("����",false);
      ����=new JRadioButton("����",false);
      group.add(��æ);
      group.add(����);
      group.add(����);
      ¼��=new JButton("¼��");
      ��ѯ=new JButton("��ѯ");
      ɾ��=new JButton("ɾ��");
      �޸�=new JButton("�޸�");
      ��ʾ=new JButton("��ʾ");
      ¼��.addActionListener(new InputAct());
      ��ѯ.addActionListener(new InquestAct());
      �޸�.addActionListener(new ModifyAct());
      ɾ��.addActionListener(new DeleteAct());
      ��ʾ.addActionListener(new ShowAct());
      �޸�.setEnabled(false);
      p7=new JPanel();
      JLabel p=new JLabel(new ImageIcon("C:\\1.png"));
      p7.add(p);
      p1=new JPanel();
      p1.add(new JLabel("·������:",JLabel.CENTER));
      p1.add(ѧ��);
      p1.add(new JLabel("      ",JLabel.CENTER));
      p2=new JPanel();
      p2.add(new JLabel("ƽ������:",JLabel.CENTER));
      p2.add(����);
      p2.add(new JLabel("s    ",JLabel.CENTER));
      p3=new JPanel();
      p3.add(new JLabel("��·״��:",JLabel.CENTER));
      p3.add(��æ);
      p3.add(����);
      p3.add(����);
      p4=new JPanel();
      p4.add(new JLabel("        �ٶ�:",JLabel.CENTER));
      p4.add(רҵ);
      p4.add(new JLabel("m/s",JLabel.CENTER));
      p5=new JPanel();
      p5.add(new JLabel("           ����:",JLabel.CENTER));
      p5.add(�꼶);
      p5.add(new JLabel("pcu/h",JLabel.CENTER));
      p6=new JPanel();
      p6.add(new JLabel("ռ����:",JLabel.CENTER));
      p6.add(����);
      p6.add(new JLabel("%",JLabel.CENTER));
      pv=new JPanel();
      pv.setLayout(new GridLayout(7,1));
      pv.add(p0);
      pv.add(p1);
      pv.add(p2);
      pv.add(p3);
      pv.add(p4);
      pv.add(p5);
      pv.add(p6);
      ph=new JPanel();
      ph.add(¼��);
      ph.add(��ѯ);
      ph.add(�޸�);
      ph.add(ɾ��);
      ph.add(��ʾ);
      file=new File("C:\\ѧ����Ϣ1.txt");
      ѧ��ɢ�б�=new Hashtable();
        if(!file.exists()){
            try{
                FileOutputStream out=new FileOutputStream(file);
                ObjectOutputStream objectOut=new ObjectOutputStream(out);
                objectOut.writeObject(ѧ��ɢ�б�);
                objectOut.close();
                out.close();
            }
            catch(IOException e){}
        }
        Container con=getContentPane();
        con.setLayout(new BorderLayout());
        con.add(lb, BorderLayout.NORTH);
        con.add(pv, BorderLayout.CENTER);
        con.add(ph, BorderLayout.SOUTH);
        con.add(p, BorderLayout.WEST);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,100,1400,400);
        setVisible(true);
    }
    public static void main(String[] args) {new ex22();}
    class InputAct implements ActionListener{
        public void actionPerformed(ActionEvent e){
           �޸�.setEnabled(false);
           String number="";
           //number=ѧ��.getText();
           Object a=·��.getSelectedItem();
           number=(String)a;
          if(number.length()>0){
              try{
                  inOne=new FileInputStream(file);
                  inTwo=new ObjectInputStream(inOne);
                  ѧ��ɢ�б�=(Hashtable)inTwo.readObject();
                  inOne.close();
                  inTwo.close();
              }
              catch(Exception ee){System.out.println("����ɢ�б�������⣡");}
              if(ѧ��ɢ�б�.containsKey(number)){
                  String warning="��·����Ϣ�Ѵ��ڣ��뵽�޸�ҳ���޸ģ�";
                  JOptionPane.showMessageDialog(null,warning,"����",
                          JOptionPane.WARNING_MESSAGE);
              }//end if1
              else{
                  String m="��·����Ϣ����¼�룡";
                  int ok=JOptionPane.showConfirmDialog(null,m,"ȷ��",
                          JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                  if(ok==JOptionPane.YES_OPTION){
                      String name=����.getText();
                      String specialty=רҵ.getText();
                      String grade=�꼶.getText();
                      String borth=����.getText();
                      String sex=null;
                      if(��æ.isSelected()){sex=��æ.getText();}
                      else if(����.isSelected()){sex=����.getText();}
                      else {sex=����.getText();}
                      ѧ��=new Inf();
                      ѧ��.setNumber(number);
                      ѧ��.setName(name);
                      ѧ��.setSpecialty(specialty);
                      ѧ��.setGrade(grade);
                      ѧ��.setBorth(borth);
                      ѧ��.setSex(sex);
                      try{
                          outOne=new FileOutputStream(file);
                          outTwo=new ObjectOutputStream(outOne);
                          ѧ��ɢ�б�.put(number,ѧ��);
                          outTwo.writeObject(ѧ��ɢ�б�);
                          outTwo.close();
                          outOne.close();
                      }
                      catch(Exception ee){System.out.println("���ɢ�б�������⣡");}
                      ѧ��.setText(null);
                      ����.setText(null);
                      רҵ.setText(null);
                      �꼶.setText(null);
                      ����.setText(null);
                  }
              }//end else1
          }//end if0
          else{
              String warning="��������·������";
              JOptionPane.showMessageDialog(null,warning,
                      "����",JOptionPane.WARNING_MESSAGE);
          }//end else0
        }//end actionPerformed
    }//end class
      class InquestAct implements ActionListener{
          public void actionPerformed(ActionEvent e){
             String number="";
             Object a=·��.getSelectedItem();
             number=(String)a;
            if(number.length()>0){
                try{
                    inOne=new FileInputStream(file);
                    inTwo=new ObjectInputStream(inOne);
                    ѧ��ɢ�б�=(Hashtable)inTwo.readObject();
                    inOne.close();
                    inTwo.close();
                }
                catch(Exception ee){System.out.println("ɢ�б������⣡");}
                if(ѧ��ɢ�б�.containsKey(number)){
                  �޸�.setEnabled(true);
                  Inf stu=(Inf)ѧ��ɢ�б�.get(number);
                  ѧ��.setText(stu.getNumber());
                  ����.setText(stu.getName());
                  רҵ.setText(stu.getSpecialty());
                  �꼶.setText(stu.getGrade());
                  ����.setText(stu.getBorth());
                  if(stu.getSex().equals("��æ")){��æ.setSelected(true);}
                  else if(stu.getSex().equals("����")){����.setSelected(true);}
                  else{����.setSelected(true);}
                }
                else{
                    �޸�.setEnabled(false);
                    String warning="��·�����޿�����Ϣ��";
                JOptionPane.showMessageDialog(null,warning,
                        "����",JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
            �޸�.setEnabled(false);
            String warning="����ѡ��·�Σ�";
                JOptionPane.showMessageDialog(null,warning,
                        "����",JOptionPane.WARNING_MESSAGE);
            }
          }
      }
       class ModifyAct implements ActionListener{
         public void actionPerformed(ActionEvent e){
             String number=ѧ��.getText();
             String name=����.getText();
             String specialty=רҵ.getText();
             String grade=�꼶.getText();
             String borth=����.getText();
             String sex=null;
             if(��æ.isSelected()){sex=��æ.getText();}
             else if(����.isSelected()){sex=����.getText();}
             else {sex=����.getText();}
             Inf ѧ��=new Inf();
             ѧ��.setNumber(number);
             ѧ��.setName(name);
             ѧ��.setSpecialty(specialty);
             ѧ��.setGrade(grade);
             ѧ��.setBorth(borth);
             ѧ��.setSex(sex);
             try{
                 outOne=new FileOutputStream(file);
                 outTwo=new ObjectOutputStream(outOne);
                 ѧ��ɢ�б�.put(number, ѧ��);
                 outTwo.writeObject(ѧ��ɢ�б�);
                 outTwo.close();
                 outOne.close();
                 ѧ��.setText(null);
                 ����.setText(null);
                 רҵ.setText(null);
                 �꼶.setText(null);
                 ����.setText(null);
             }
             catch(Exception ee){
                 System.out.println("¼���޸ĳ����쳣!");
                 �޸�.setEnabled(false);
             }
         }
     }
     class DeleteAct implements ActionListener{
         public void actionPerformed(ActionEvent e){
             �޸�.setEnabled(false);
             String number=ѧ��.getText();
            if(number.length()>0){
                try{
                    inOne=new FileInputStream(file);
                    inTwo=new ObjectInputStream(inOne);
                    ѧ��ɢ�б�=(Hashtable)inTwo.readObject();
                    inOne.close();
                    inTwo.close();
                }
                catch(Exception ee){}
                if(ѧ��ɢ�б�.containsKey(number)){
                  Inf stu=(Inf)ѧ��ɢ�б�.get(number);
                  ����.setText(stu.getName());
                  רҵ.setText(stu.getSpecialty());
                  �꼶.setText(stu.getGrade());
                  ����.setText(stu.getBorth());
                  if(stu.getSex().equals("��æ")){��æ.setSelected(true);}
                  else if(stu.getSex().equals("����")){����.setSelected(true);}
                  else{����.setSelected(true);}
                }
                String m="ȷ��Ҫɾ����ѧ���ļ�¼��";
                int ok=JOptionPane.showConfirmDialog(null,m,"ȷ��",
                   JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(ok==JOptionPane.YES_OPTION){
                	ѧ��ɢ�б�.remove(number);
                    try{
                        outOne=new FileOutputStream(file);
                        outTwo=new ObjectOutputStream(outOne);
                        outTwo.writeObject(ѧ��ɢ�б�);
                        outTwo.close();
                        outOne.close();
                        ѧ��.setText(null);
                        ����.setText(null);
                        רҵ.setText(null);
                        �꼶.setText(null);
                        ����.setText(null);
                    }
                    catch(Exception ee){System.out.println(ee);}
                }
                else if(ok==JOptionPane.NO_OPTION){
                    ѧ��.setText(null);
                    ����.setText(null);
                    רҵ.setText(null);
                    �꼶.setText(null);
                    ����.setText(null);
                }
                else{
                    String warning="��ѧ�Ų����ڣ�";
                    JOptionPane.showMessageDialog(null,warning,
                            "����",JOptionPane.WARNING_MESSAGE);
                }
            }
            else{
                 String warning="��������ѧ�ţ�";
                 JOptionPane.showMessageDialog(null,warning,
                        "����",JOptionPane.WARNING_MESSAGE);
            }
         }
     }
     class ShowAct implements ActionListener{
         public void actionPerformed(ActionEvent e){
             new Show1(file);
         }
     }
     class Show1 extends JDialog{
         Hashtable ѧ��ɢ�б�= null;
         JTextArea ��ʾ=null;
         FileInputStream inOne=null;
         ObjectInputStream inTwo=null;
         File file=null;
         public Show1(File file){
             super(new JFrame(),"·����Ϣ");
             this.file=file;
             ��ʾ=new JTextArea(20,40);
             try{
                 inOne=new FileInputStream(file);
                 inTwo=new ObjectInputStream(inOne);
                 ѧ��ɢ�б�=(Hashtable)inTwo.readObject();
                 inOne.close();
                 inTwo.close();
             }
             catch(Exception ee){}
             if(ѧ��ɢ�б�.isEmpty())��ʾ.append("Ŀǰ��û��·����Ϣ��¼��\n");
             else{
                 ��ʾ.setText("·���� ƽ������ ��·״̬ �ٶ�  ����  ռ����\n");
                 for(Enumeration enm=ѧ��ɢ�б�.elements();enm.hasMoreElements();){
                     Inf stu=(Inf)enm.nextElement();
                     String sex="";
                     if(stu.getSex().equals("��æ"))sex="��æ";
                     else if(stu.getSex().equals("����"))sex="����";
                     else sex="����";
                     String str=stu.getNumber()+"   "+stu.getName()+"   "+sex+"   "
                             +stu.getSpecialty()+"   "+stu.getGrade()+"   "+stu.getBorth()+"\n";
                     ��ʾ.append(str);
                 }
             }
             JScrollPane scroll=new JScrollPane(��ʾ);
             Container con=getContentPane();
             con.add("Center",scroll);
             con.validate();
             setVisible(true);
             setBounds(200,200,400,300);
             addWindowListener(new WindowAdapter(){
                 public void windowClosing(WindowEvent e){setVisible(false);}
             }
             );
         }
     }
  }
