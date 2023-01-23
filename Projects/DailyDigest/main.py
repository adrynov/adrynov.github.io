from content import get_random_quote


class DailyDigest:

    def __init__(self):
        pass

    # TODO
    # configure what content to include
    # add / remove recipients
    # schedule daily time to send email
    # configure sender credentials

    def send_email(self):
        pass

    def format_message(self):
        pass


if __name__ == '__main__':
    print('Testing quote generation\n')

    quote = get_random_quote()
    print(f' - Random quote is "{quote["quote"]} - {quote["author"]}"')

    # root = Tk()
    # app = DigestGUI()
    # root.mainloop()
