package bataillemoi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Plateau {
    private JPanel total;
    private JButton mesBoutons[] = new JButton[121];
    int nombreBateau = 0;
    int nombreBateauCoule = 0;
    
    public Plateau() {

        JPanel grille = new JPanel();
        
        
        total = new JPanel(); // On crée le contenair qui aura le JLabel
        
        total.setLayout(new BorderLayout()); // On le positione ! Ici, mode par défaut
        
        grille = new JPanel();
        grille.setLayout(new GridLayout(11,11));
        
        int taille = 0, lettre = 65, numero = 0;
        for(int i=0;i<11;i++) {
            for(int j=0;j<11;j++) {
                mesBoutons[taille] = new JButton("");
                mesBoutons[taille].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                    	JButton j = (JButton) e.getSource();
                    	
                    	if(nombreBateau != 17)
                    	{
                    		placerBateau(j);		
                    	}		
                    	
                    	else if (nombreBateau == 17 && nombreBateauCoule != 17)
                    		
                    	{
                    		TirerBateau(j);
                    	}
                    	
                    	else if (nombreBateauCoule == 17 && nombreBateau == 17 )
                    	{
                    		System.out.println("Vous avez gagné !");
                    		System.exit(0);
                    	}
                        
                        
                        
                    }
                });
                
                
                if(i==0&&j==0) mesBoutons[taille].setBackground(Color.BLACK);
                if(i==0&&j!=0) {
                    mesBoutons[taille].setText(""+numero);
                    mesBoutons[taille].setBackground(Color.darkGray);
                    mesBoutons[taille].setForeground(Color.YELLOW);
                    mesBoutons[taille].setBorder(BorderFactory.createEtchedBorder(Color.green, Color.cyan));
                    numero++;
                }
                if(j==0&&i!=0) {
                    mesBoutons[taille].setText(""+(char)lettre);
                    mesBoutons[taille].setBackground(Color.darkGray);
                    mesBoutons[taille].setForeground(Color.YELLOW);
                    mesBoutons[taille].setBorder(BorderFactory.createEtchedBorder(Color.green, Color.cyan));
                    lettre++;
                }
                if(i>0&&j>0) {
                    mesBoutons[taille].setText("~~~");
                }
                
                grille.add(mesBoutons[taille]); 
                taille++;
            }
        }
        
        total.add(grille);
        
       
    }
    
    public JPanel getTotal() {
        return total;
    }
    
    public JButton[] getMesBoutons() {
        return mesBoutons;
    }
    
    public void placerBateau(JButton bouton)
    {
    	if(bouton.getText() == "Bateau")
		{
			System.out.println("Un bateau est déja présent sur cette case");
		}
   else
		{
			bouton.setText("Bateau");
    		nombreBateau++;
		}
    }
    
    public void TirerBateau(JButton bouton)
    {	
    	if(nombreBateauCoule != 17)
    	{
    		
    		if(bouton.getText() == "Bateau")
    		{
    			bouton.setText("Touché");
    			bouton.setBackground(Color.RED);
    			nombreBateauCoule++;
    		}
    	
    		else if (bouton.getText() == "Touché")
    		{
    			System.out.println("Ce bateau est déjà touché");
    		}
    	else
    		{
    			bouton.setText("Raté");
    			bouton.setBackground(Color.WHITE);
    		}
    	
    	}
    	
    }
    
    public static void main(String[] args)
    {
        Plateau plateau = new Plateau();
        
        JFrame frame = new JFrame();
        frame.setContentPane(plateau.getTotal());
        frame.pack();
        frame.setVisible(true);
       
        
    }
    
}