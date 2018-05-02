import socket
import sys

def main(mensagem):

    # Create a TCP/IP socket
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Connect the socket to the port where the server is listening
    server_address = ('192.168.8.2', 10000)
    print >>sys.stderr, 'connecting to %s port %s' % server_address
    sock.connect(server_address)
    ponto = ["Ave Afonso Pena 354", "Ave Afonso Pena 367", "Ave Afonso Pena 388", "Ave Afonso Pena 540", "Ave Afonso Pena 571","Ave Afonso Pena 749","Ave Afonso Pena 776"]
    try:
        
        # Send data
        message = str("1:")+str(mensagem)
        sock.send(message)

        # Look for the response

    finally:
        print >>sys.stderr, 'closing socket'
        sock.close()



'''
Ave Afonso Pena 354, Associacao Comercial - 2 ( Entre Rua Curitiba E Rua Dos Tupinambas ), -43.94023816216864, -19.91686541355103,,
Ave Afonso Pena 367, Cine Royal - 1 ( Entre Rua Sao Paulo E Rua Dos Caetes ), -43.94000100026517, -19.91657097563864,,
Ave Afonso Pena 388, Associacao Comercial ( Entre Rua Dos Tupinambas E Rua Curitiba ), -43.94007537903294, -19.91710786219968,,
Ave Afonso Pena 540, Praca Sete - Edficio Mariana ( Entre Rua Sao Paulo E Ave Amazonas ), -43.93935167983308, -19.91830003985224,,
Ave Afonso Pena 571, Praca Sete - Hotel Financial ( Entre Ave Amazonas E Rua Dos Tupinambas ), -43.93883380426277, -19.91838233618019,,
Ave Afonso Pena 749, Praca Sete - Casa Da Fotografia ( Entre Rua Espirito Santo E Ave Amazonas ), -43.93803536186732, -19.91977754299357,,
Ave Afonso Pena 776, Praca Sete - Banco Da Lavoura ( Entre Ave Amazonas E Rua Dos Tamoios ), -43.93819487792267, -19.92015410503316,,
Ave Afonso Pena 942, Edifico Guimaraes ( Entre Rua Espirito Santo E Rua Dos Tupis ), -43.93737994846106, -19.92146942538846,,
Ave Afonso Pena 965, Edificio Sulacap ( Entre Rua Da Bahia E Rua Dos Tamoios ), -43.93699319967026, -19.92139979824636,,
Ave Afonso Pena 1148, Prefeitura - 1 ( Entre Rua Da Bahia E Ave Alvares Cabral ), -43.93640777948591, -19.9230229723914,,
Ave Afonso Pena 1149, Parque Municipal - Mercado Das Flores ( Entre Ave Carandai E Rua Da Bahia ), -43.93613035041491, -19.92279226040782,,
Ave Afonso Pena 1162, Prefeitura - 2 ( Entre Rua Da Bahia E Ave Alvares Cabral ), -43.93634365356242, -19.92312586538661,,
Ave Afonso Pena 1213, Parque Municipal - Oposto A Prefeitura ( Entre Ave Carandai E Rua Da Bahia ), -43.93570865609168, -19.92347553663693,,
Ave Afonso Pena 1270, Correios ( Entre Rua Da Bahia E Ave Alvares Cabral ), -43.93580706094854, -19.92400371311414,,
Ave Afonso Pena 1271, Parque Municipal - Oposto A Prefeitura ( Entre Ave Carandai E Rua Da Bahia ), -43.93546024265731, -19.92387694556892,,
Ave Afonso Pena 1421, Oposto Ao Conservatorio De Musica - Ufmg ( Entre Ave Carandai E Rua Da Bahia ), -43.93477081745877, -19.92497723384708,,
Ave Afonso Pena 1501, Palacio Das Artes - Parque Municipal ( Entre Ave Carandai E Rua Da Bahia ), -43.93450585978982, -19.9253945350086,,
Ave Afonso Pena 1534, Conservatorio Ufmg ( Entre Ave Alvares Cabral E Rua Dos Guajajaras ), -43.93449136582824, -19.92610310806154,,
Ave Afonso Pena 1734, Subestacao Da Cemig ( Entre Rua Alagoas E Rua Dos Timbiras ), -43.9336853607499, -19.92741746777316,,
Ave Afonso Pena 1781, Oposto A Subestacao Da Cemig ( Entre Rua Pernambuco E Ave Carandai ), -43.93300958798038, -19.92780329699709,,
Ave Afonso Pena 1901, Praca Tiradentes - 2 ( Entre Ave Brasil E Rua Dos Timbiras ), -43.93226650395133, -19.92899261330859,,
Ave Afonso Pena 1908, Oposto Ao Instituto De Educacao De Mg ( Entre Rua Pernambuco E Ave Brasil ), -43.93270817451963, -19.9289814417919,,
Ave Afonso Pena 2323, ( Entre Ave Bernardo Monteiro E Rua Bernardo Guimaraes ), -43.93041205072204, -19.93197141916303,,
Ave Afonso Pena 2372, Secretaria De Estado Da Saude ( Entre Rua Rio Grande Do Norte E Rua Goncalves Dias ), -43.93047825467153, -19.93256888721897,,
Ave Afonso Pena 2755, Praca Abc - 2 ( Entre Rua Piaui E Rua Claudio Manoel ), -43.92841907171898, -19.93522070407363,,
Ave Afonso Pena 2770, Praca Abc - 1 ( Entre Ave Getulio Vargas E Rua Santa Rita Durao ), -43.92857633948663, -19.93557503281694,,
Ave Afonso Pena 2981, Corpo Bombeiros - 2 ( Entre Rua Maranhao E Rua Piaui ), -43.92730299985305, -19.93700427260867,,
'''
if __name__ == '__main__':
    main()
